package com.arthur.meal_db.ui.screens.categoryList

import com.arthur.meal_db.data.model.CategorySimple

data class CategoryListUiState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val categoryList: List<CategorySimple> = emptyList()
)