package com.arthur.meal_db.ui.screens.category_list

import com.arthur.meal_db.data.model.CategorySimple
import com.arthur.meal_db.data.model.MealCoverSimple

data class CategoryListUiState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val activeSearch: Boolean = false,
    val categoryList: List<CategorySimple> = emptyList(),
    val randomMealList: List<MealCoverSimple> = emptyList(),
    val mealList: List<MealCoverSimple> = emptyList(),
    val query: String = ""
)