package com.arthur.meal_db.ui.screens.meals_by_category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthur.meal_db.data.repository.meals_by_category_repository.repositorys.MealsByCategoryTasks
import com.arthur.meal_db.ui.NavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class MealsByCategoryViewModel @Inject constructor(
    private val mealsByCategoryTasks: MealsByCategoryTasks,
    savedStateHandle: SavedStateHandle?
) : ViewModel() {

    private val vmUiState = MutableStateFlow(MealsByCategoryUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    private var mealCategory: String? = savedStateHandle?.get(NavArgs.MEAL_CATEGORY)

    init {
        mealCategory?.let { safeMealCategory ->
            vmUiState.update { it.copy(mealCategory = safeMealCategory) }
            getCategoryList(safeMealCategory)
        } ?: run {
            vmUiState.update { it.copy(errorMessage = "Hubo un problema al consultar la información.") }
        }
    }

    private fun getCategoryList(category: String) {
        vmUiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            mealsByCategoryTasks.getMealCoverList(category).collect { mList ->
                vmUiState.update {
                    it.copy(
                        loading = false,
                        errorMessage = mList.errorMessage,
                        mealList = mList.mealCoverSimpleList
                    )
                }
            }
        }
    }

    fun clearErrorMsg() {
        vmUiState.update { it.copy(errorMessage = null) }
    }
}