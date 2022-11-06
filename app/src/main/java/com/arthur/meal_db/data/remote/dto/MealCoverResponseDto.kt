package com.arthur.meal_db.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MealCoverResponseDto(
    @SerializedName("meals") var mealsCoverList: List<MealCoverDto>? = listOf()
)

data class MealCoverDto(
    @SerializedName("strMeal") var strMeal: String? = null,
    @SerializedName("strMealThumb") var strMealThumb: String? = null,
    @SerializedName("idMeal") var idMeal: String? = null
)
