package com.arthur.meal_db.data.repository.category_list_repository.remote_data_source

import com.arthur.meal_db.data.remote.api.MealDbApi
import com.arthur.meal_db.data.remote.dto.CategoryResponseDto
import com.arthur.meal_db.data.repository.category_list_repository.repositorys.MealCategoryListRemoteDataSource
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.networkCall

class MealCategoryListRetrofitRemoteDataSource(
    private val mealDbApi: MealDbApi
) : MealCategoryListRemoteDataSource {

    override suspend fun getCategoryList(): ServiceResult<CategoryResponseDto> =
        networkCall {
            mealDbApi.getCategoryList().body()!!
        }

}