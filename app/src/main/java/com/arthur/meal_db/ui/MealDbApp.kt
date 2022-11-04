package com.arthur.meal_db.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arthur.meal_db.ui.theme.MealDbTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun MealDbApp() {
    MealDbTheme {
        val navController = rememberNavController()

        Scaffold {
            MealDbNavGraph(
                navController = navController
            )
        }

    }
}