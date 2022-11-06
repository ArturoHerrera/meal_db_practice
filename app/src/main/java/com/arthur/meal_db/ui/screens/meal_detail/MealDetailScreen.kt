package com.arthur.meal_db.ui.screens.meal_detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.*
import com.arthur.meal_db.ui.theme.BackgroundWhite
import com.arthur.meal_db.ui.theme.YellowDelicious
import com.google.gson.Gson

@Composable
fun MealDetailScreen(
    upPress: () -> Unit,
    viewModel: MealDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) { paddingValues ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(BackgroundWhite)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top
            ) {
                uiState.mealDetail?.let {
                    Log.i("testDetail", "--> ${Gson().toJson(it)}")
                    MealDetailHeader(it)
                    if(it.ingredientList.isNotEmpty()) IngredientsList(it.ingredientList)
                    MealInstructions(it)
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
