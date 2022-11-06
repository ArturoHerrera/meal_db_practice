package com.arthur.meal_db.ui.screens.meal_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthur.meal_db.data.repository.meal_detail_repository.repositorys.MealDetailTasks
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
class MealDetailViewModel @Inject constructor(
    private val mealDetailsTasks: MealDetailTasks,
    savedStateHandle: SavedStateHandle?
) : ViewModel() {

    private val vmUiState =
        MutableStateFlow(MealDetailUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    private var mealId: String? = savedStateHandle?.get(NavArgs.MEAL_ID)

    init {
        mealId?.let { safeMealId ->
            getMealDetail(safeMealId)
        } ?: run {
            vmUiState.update { it.copy(errorMessage = "Hubo un problema al consultar la información.") }
        }
    }

    fun getMealDetail(mealId: String) {
        vmUiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            mealDetailsTasks.getMealDetail(mealId).collect { result ->
                vmUiState.update {
                    it.copy(
                        loading = false,
                        errorMessage = result.errorMessage,
                        mealDetail = result.mealDetail
                    )
                }
            }
        }
    }

    fun clearErrorMsg() {
        vmUiState.update { it.copy(errorMessage = null) }
    }

}