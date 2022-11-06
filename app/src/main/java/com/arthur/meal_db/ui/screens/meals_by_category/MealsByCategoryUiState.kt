package com.arthur.meal_db.ui.screens.meals_by_category

import com.arthur.meal_db.data.model.MealCoverSimple

data class MealsByCategoryUiState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val mealList: List<MealCoverSimple> = emptyList()
)