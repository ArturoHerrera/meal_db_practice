package com.arthur.meal_db.ui.screens.mealDetail

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

    private var mealId: Long? = savedStateHandle?.get(NavArgs.MEAL_ID)

    init {
        mealId?.let { safeMealId ->
            getMealDetail(safeMealId.toString())
        } ?: kotlin.run {
            vmUiState.update { it.copy(errorMsg = "Hubo un problema al consultar la información.") }
        }
    }

    fun getMealDetail(mealId: String) {
        vmUiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            mealDetailsTasks.getMealDetail(mealId).collect { mealDetail ->
                vmUiState.update {
                    it.copy(
                        loading = false,
                        errorMsg = mealDetail.errorMessage
                    )
                }
            }
        }
    }

    fun clearErrorMsg() {
        vmUiState.update { it.copy(errorMsg = null) }
    }

}