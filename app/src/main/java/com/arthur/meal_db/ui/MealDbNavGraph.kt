package com.arthur.meal_db.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arthur.meal_db.ui.screens.categoryList.CategoryListScreen
import com.arthur.meal_db.ui.screens.mealDetail.MealDetailScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

object Destinations {
    const val CATEGORY_LIST_SCREEN = "catalog_list_screen"
    const val MEAL_DETAIL_SCREEN = "meal_detail"
}

object NavArgs {
    const val MEAL_ID = "id_meal"
    const val MEAL_CATEGORY = "meal_category"
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun MealDbNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.CATEGORY_LIST_SCREEN
) {
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Destinations.CATEGORY_LIST_SCREEN
        ) {
            CategoryListScreen(
                navigateToMealDetail = actions.navigateToMealDetail,
            )
        }
        composable(
            route = Destinations.MEAL_DETAIL_SCREEN + "/{${NavArgs.MEAL_ID}}",
            arguments = listOf(navArgument(NavArgs.MEAL_ID) { type = NavType.LongType })
        ) {
            MealDetailScreen(
                navigateToView = actions.upPress
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToMealDetail: (Long) -> Unit = { mealId ->
        navController.navigate(Destinations.MEAL_DETAIL_SCREEN + "/$mealId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}