package com.arthur.meal_db.data.repository.meal_detail_repository.repositorys

import com.arthur.meal_db.data.model.MealDetail
import com.arthur.meal_db.data.model.MealDetailSimple
import com.arthur.meal_db.data.remote.dto.MealDetailResponseDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.getDto
import com.arthur.meal_db.utils.getMessage
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MealDetailRepository(
    private val mealDetailRemoteDS: MealDetailRemoteDataSource
) : MealDetailTasks {

    override suspend fun getMealDetail(mealId: String): Flow<MealDetail> = flow {
        emit(mealDetailRemoteDS.getMealDetail(mealId))
    }.map { result ->
        if (result.succeeded) {
            val mDto = result.getDto().meals.first()
            val mMealDetailSimple = MealDetailSimple.Builder()
                .setMealName(mDto.strMeal)
                .setMealId(mDto.idMeal)
                .setDrinkAlternate(mDto.strDrinkAlternate)
                .setCategory(mDto.strCategory)
                .setArea(mDto.strArea)
                .setInstructions(mDto.strInstructions)
                .setMealThumb(mDto.strMealThumb)
                .setTags(mDto.strTags)
                .setUrlYoutube(mDto.strYoutube)
                .setIngredientList(mDto.getIngredientList())
                .setSource(mDto.strSource)
                .setImgSource(mDto.strImageSource)
                .build()
            MealDetail(
                errorMessage = null,
                mealDetail = mMealDetailSimple
            )
        } else {
            MealDetail(
                errorMessage = result.getMessage(),
                mealDetail = null
            )
        }
    }.catch { e -> e.printStackTrace() }
        .flowOn(Dispatchers.IO)

}

interface MealDetailRemoteDataSource {
    suspend fun getMealDetail(mealId: String): ServiceResult<MealDetailResponseDto>
}