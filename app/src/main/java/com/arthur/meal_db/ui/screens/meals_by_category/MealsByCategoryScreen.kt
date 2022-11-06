package com.arthur.meal_db.ui.screens.meals_by_category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.ErrorAlert
import com.arthur.meal_db.ui.screens.components.MealByCategoryList
import com.arthur.meal_db.ui.screens.components.MealsByCategoryListyHeader
import com.arthur.meal_db.ui.screens.components.ProgressBar
import com.arthur.meal_db.ui.theme.YellowDelicious
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun MealsByCategoryScreen(
    upPress: () -> Unit,
    navigateToMealDetail: (Long) -> Unit,
    viewModel: MealsByCategoryViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MealsByCategoryListyHeader(uiState.mealCategory)
        }
    ) { paddingValues ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(YellowDelicious),
                verticalArrangement = Arrangement.Top
            ) {
                MealByCategoryList(
                    mealList = uiState.mealList,
                    onMealClicked = {}
                )
            }
        }
        ProgressBar(state = uiState.loading)
        uiState.errorMessage?.let { safeErrorMsg ->
            ErrorAlert(
                errorMsg = safeErrorMsg,
                onDismiss = { viewModel.clearErrorMsg() }
            )
        }
    }
}
