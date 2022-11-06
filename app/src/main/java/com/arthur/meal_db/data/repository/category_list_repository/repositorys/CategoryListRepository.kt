package com.arthur.meal_db.data.repository.category_list_repository.repositorys

import com.arthur.meal_db.data.model.CategoryList
import com.arthur.meal_db.data.model.CategorySimple
import com.arthur.meal_db.data.remote.dto.CategoryResponseDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.getDto
import com.arthur.meal_db.utils.getMessage
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class CategoryListRepository(
    private val mealCategoryListRemoteDS: MealCategoryListRemoteDataSource
) : CategoryListTasks {

    override suspend fun getCategoryList(): Flow<CategoryList> = flow {
        emit(mealCategoryListRemoteDS.getCategoryList())
    }.map { result ->
        if (result.succeeded) {
            val mList = result.getDto().categories.map { mCategory ->
                CategorySimple.Builder()
                    .setId(mCategory.idCategory)
                    .setCategoryThumb(mCategory.strCategoryThumb)
                    .setCategory(mCategory.strCategory)
                    .setCategoryDescription(mCategory.strCategoryDescription)
                    .build()
            }
            CategoryList(
                categorySimpleList = mList,
                errorMessage = null
            )
        } else {
            CategoryList(
                categorySimpleList = emptyList(),
                errorMessage = result.getMessage()
            )
        }
    }.catch { e -> e.printStackTrace() }
        .flowOn(Dispatchers.IO)
}

interface MealCategoryListRemoteDataSource {
    suspend fun getCategoryList(): ServiceResult<CategoryResponseDto>
}