package com.arthur.meal_db.data.repository.meals_by_category_repository.remote_data_source

import com.arthur.meal_db.data.remote.api.MealDbApi
import com.arthur.meal_db.data.remote.dto.MealCoverDto
import com.arthur.meal_db.data.repository.meals_by_category_repository.repositorys.MealsByCategoryRemoteDataSource
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.networkCall

class MealsByCategoryRetrofitRemoteDataSource(
    private val mealDbApi: MealDbApi
) : MealsByCategoryRemoteDataSource {

    override suspend fun getMealsByCategory(category: String): ServiceResult<List<MealCoverDto>> =
        networkCall {
            mealDbApi.getMealsByCategory(category).body()!!.mealsCoverList
        }

}