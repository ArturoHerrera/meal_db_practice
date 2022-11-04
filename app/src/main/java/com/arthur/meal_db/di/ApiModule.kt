package com.arthur.meal_db.di

import com.arthur.meal_db.data.remote.api.MealDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideMealDbService(retrofit: Retrofit): MealDbApi = retrofit.create(MealDbApi::class.java)

}