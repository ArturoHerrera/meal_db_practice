package com.arthur.meal_db.data.repository.meals_by_category_repository.repositorys

import com.arthur.meal_db.data.model.MealCoverList
import com.arthur.meal_db.data.model.MealCoverSimple
import com.arthur.meal_db.data.remote.dto.MealCoverDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.getDto
import com.arthur.meal_db.utils.getMessage
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MealsByCategoryRepository(
    private val mealsByCategoryRemoteDS: MealsByCategoryRemoteDataSource
) : MealsByCategoryTasks {

    override suspend fun getMealCoverList(category: String): Flow<MealCoverList> = flow {
        emit(mealsByCategoryRemoteDS.getMealsByCategory(category))
    }.map { result ->
        if (result.succeeded) {
            val mList = result.getDto().map { mMealCover ->
                MealCoverSimple.Builder()
                    .setMealId(mMealCover.idMeal)
                    .setMealImageUrl(mMealCover.strMealThumb)
                    .setMealName(mMealCover.strMeal)
                    .build()
            }
            MealCoverList(
                errorMessage = null,
                mealCoverSimpleList = mList
            )
        } else {
            MealCoverList(
                errorMessage = result.getMessage(),
                mealCoverSimpleList = listOf()
            )
        }
    }.catch { e -> e.printStackTrace() }
        .flowOn(Dispatchers.IO)

}

interface MealsByCategoryRemoteDataSource {
    suspend fun getMealsByCategory(category: String): ServiceResult<List<MealCoverDto>>
}