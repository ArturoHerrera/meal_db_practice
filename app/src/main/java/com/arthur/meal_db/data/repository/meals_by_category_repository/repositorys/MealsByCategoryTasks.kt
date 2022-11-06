package com.arthur.meal_db.data.repository.meals_by_category_repository.repositorys

import com.arthur.meal_db.data.model.MealCoverList
import kotlinx.coroutines.flow.Flow

interface MealsByCategoryTasks {

    suspend fun getMealCoverList(category: String): Flow<MealCoverList>

}