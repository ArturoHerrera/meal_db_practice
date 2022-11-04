package com.arthur.meal_db.data.repository.meal_detail_repository.remote_data_source

import com.arthur.meal_db.data.remote.api.MealDbApi
import com.arthur.meal_db.data.remote.dto.MealDetailResponseDto
import com.arthur.meal_db.data.repository.meal_detail_repository.repositorys.MealDetailRemoteDataSource
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.networkCall

class MealDetailRetrofitRemoteDataSource(
    private val mealDbApi: MealDbApi
) : MealDetailRemoteDataSource {

    override suspend fun getMealDetail(mealId: String): ServiceResult<MealDetailResponseDto> =
        networkCall {
            mealDbApi.getMealDetail(mealId = mealId).body()!!
        }

}