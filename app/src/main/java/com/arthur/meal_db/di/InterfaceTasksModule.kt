package com.arthur.meal_db.di

import com.arthur.meal_db.data.repository.meal_detail_repository.repositorys.MealDetailRepository
import com.arthur.meal_db.data.repository.meal_detail_repository.repositorys.MealDetailTasks
import com.arthur.meal_db.data.repository.category_list_repository.repositorys.CategoryListRepository
import com.arthur.meal_db.data.repository.category_list_repository.repositorys.CategoryListTasks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InterfaceTasksModule {

    @Binds
    abstract fun bindsCategoryListTasks(
        repository: CategoryListRepository
    ): CategoryListTasks


    @Binds
    abstract fun bindsMealDetailTasks(
        repository: MealDetailRepository
    ): MealDetailTasks


}