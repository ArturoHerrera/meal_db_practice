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
import com.arthur.meal_db.ui.screens.category_list.CategoryListScreen
import com.arthur.meal_db.ui.screens.meal_detail.MealDetailScreen
import com.arthur.meal_db.ui.screens.meals_by_category.MealsByCategoryScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

object Destinations {
    const val CATEGORY_LIST_SCREEN = "catalog_list_screen"
    const val MEAL_DETAIL_SCREEN = "meal_detail"
    const val MEAL_BY_CATEGORY_SCREEN = "meals_by_category"
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
                navigateToMealsByCategory = actions.navigateToMealsByCategory,
            )
        }
        composable(
            route = Destinations.MEAL_BY_CATEGORY_SCREEN + "/{${NavArgs.MEAL_CATEGORY}}",
            arguments = listOf(navArgument(NavArgs.MEAL_CATEGORY) { type = NavType.StringType })
        ) {
            MealsByCategoryScreen(
                upPress = actions.upPress,
                navigateToMealDetail = actions.navigateToMealDetail
            )
        }
        composable(
            route = Destinations.MEAL_DETAIL_SCREEN + "/{${NavArgs.MEAL_ID}}",
            arguments = listOf(navArgument(NavArgs.MEAL_ID) { type = NavType.StringType })
        ) {
            MealDetailScreen(
                upPress = actions.upPress
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToMealsByCategory: (String) -> Unit = { mealCategory ->
        navController.navigate(Destinations.MEAL_BY_CATEGORY_SCREEN + "/$mealCategory")
    }
    val navigateToMealDetail: (String) -> Unit = { mealId ->
        navController.navigate(Destinations.MEAL_DETAIL_SCREEN + "/$mealId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}