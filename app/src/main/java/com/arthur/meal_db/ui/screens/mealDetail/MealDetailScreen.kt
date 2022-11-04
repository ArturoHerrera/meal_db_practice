package com.arthur.meal_db.ui.screens.mealDetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.*

@Composable
fun MealDetailScreen(
    navigateToView: () -> Unit,
    viewModel: MealDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) { paddingValues ->
        Box {

        }

        ProgressBar(state = uiState.loading)
        uiState.errorMsg?.let { safeErrorMsg ->
            ErrorAlert(
                errorMsg = safeErrorMsg,
                onDismiss = { viewModel.clearErrorMsg() }
            )
        }
    }
}