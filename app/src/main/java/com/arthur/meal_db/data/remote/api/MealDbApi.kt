package com.arthur.meal_db.data.remote.api

import com.arthur.meal_db.data.remote.dto.CategoryResponseDto
import com.arthur.meal_db.data.remote.dto.MealCoverResponseDto
import com.arthur.meal_db.data.remote.dto.MealDetailResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MealDbApi {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategoryList(
    ): Response<CategoryResponseDto>

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getMealDetail(
        @Query("i") mealId: String = "Z"
    ): Response<MealDetailResponseDto>

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): Response<MealCoverResponseDto>

}