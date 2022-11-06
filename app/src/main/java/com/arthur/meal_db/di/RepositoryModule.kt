package com.arthur.meal_db.di

import com.arthur.meal_db.data.remote.api.MealDbApi
import com.arthur.meal_db.data.repository.category_list_repository.remote_data_source.MealCategoryListRetrofitRemoteDataSource
import com.arthur.meal_db.data.repository.category_list_repository.repositorys.CategoryListRepository
import com.arthur.meal_db.data.repository.meal_detail_repository.remote_data_source.MealDetailRetrofitRemoteDataSource
import com.arthur.meal_db.data.repository.meal_detail_repository.repositorys.MealDetailRepository
import com.arthur.meal_db.data.repository.meals_by_category_repository.remote_data_source.MealsByCategoryRetrofitRemoteDataSource
import com.arthur.meal_db.data.repository.meals_by_category_repository.repositorys.MealsByCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesCategoryListRepository(
        mealDbApi: MealDbApi
    ): CategoryListRepository = CategoryListRepository(
        mealCategoryListRemoteDS = MealCategoryListRetrofitRemoteDataSource(
            mealDbApi = mealDbApi
        )
    )

    @ViewModelScoped
    @Provides
    fun providesMealsByCategoryRepository(
        mealDbApi: MealDbApi
    ): MealsByCategoryRepository = MealsByCategoryRepository(
        mealsByCategoryRemoteDS = MealsByCategoryRetrofitRemoteDataSource(
            mealDbApi = mealDbApi
        )
    )

    @ViewModelScoped
    @Provides
    fun providesMealDetailRepository(
        mealDbApi: MealDbApi
    ): MealDetailRepository = MealDetailRepository(
        mealDetailRemoteDS = MealDetailRetrofitRemoteDataSource(
            mealDbApi = mealDbApi
        )
    )

}