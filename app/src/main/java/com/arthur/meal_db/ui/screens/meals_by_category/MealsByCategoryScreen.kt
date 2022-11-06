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
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.ErrorAlert
import com.arthur.meal_db.ui.screens.components.ProgressBar
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

        }
    ) { paddingValues ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Black.copy(alpha = 0.9f)),
                verticalArrangement = Arrangement.Top
            ) {
                uiState.mealList.forEach {
                    Text(text = "receta -> ${it.mealName}")
                }
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
