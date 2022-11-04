package com.arthur.meal_db.data.repository.meal_detail_repository.repositorys

import com.arthur.meal_db.data.model.MealDetail
import kotlinx.coroutines.flow.Flow

interface MealDetailTasks {

    /*
    *   Al tener nuestro manifiesto de tareas,
    *   podemos implementar esta interface en un
    *   repositorio de prueba, para facilitar y promover
    *   el testing.
    */

    suspend fun getMealDetail(mealId: String): Flow<MealDetail>
}