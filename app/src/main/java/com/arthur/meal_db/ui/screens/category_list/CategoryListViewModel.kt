package com.arthur.meal_db.ui.screens.category_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthur.meal_db.data.repository.category_list_repository.repositorys.CategoryListTasks
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
class CategoryListViewModel @Inject constructor(
    private val categoryListTasks: CategoryListTasks
) : ViewModel() {

    private val vmUiState = MutableStateFlow(CategoryListUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    init {
        getCategoryList()
    }

    private fun getCategoryList() {
        vmUiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            categoryListTasks.getCategoryList().collect { mList ->
                vmUiState.update {
                    it.copy(
                        loading = false,
                        errorMessage = mList.errorMessage,
                        categoryList = mList.categorySimpleList
                    )
                }
            }
        }
    }


    fun clearErrorMsg() {
        vmUiState.update { it.copy(errorMessage = null) }
    }
}