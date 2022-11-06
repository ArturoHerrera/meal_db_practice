package com.arthur.meal_db.data.repository.category_list_repository.repositorys

import com.arthur.meal_db.data.model.CategoryList
import com.arthur.meal_db.data.model.MealCoverList
import kotlinx.coroutines.flow.Flow

interface CategoryListTasks {

    /*
    *   Al tener nuestro manifiesto de tareas,
    *   podemos implementar esta interface en un
    *   repositorio para pruebas, para facilitar y promover
    *   el testing.
    */

    suspend fun getCategoryList(): Flow<CategoryList>

    suspend fun getRandomMeal(): Flow<MealCoverList>

    suspend fun searchMeal(query: String): Flow<MealCoverList>

}