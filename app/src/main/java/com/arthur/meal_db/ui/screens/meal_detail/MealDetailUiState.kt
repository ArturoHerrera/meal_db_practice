package com.arthur.meal_db.ui.screens.meal_detail

import com.arthur.meal_db.data.model.MealDetailSimple


data class MealDetailUiState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val mealDetail: MealDetailSimple? = null
)