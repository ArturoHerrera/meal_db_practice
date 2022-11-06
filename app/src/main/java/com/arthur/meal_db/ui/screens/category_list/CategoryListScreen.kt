package com.arthur.meal_db.ui.screens.category_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.*
import com.arthur.meal_db.ui.theme.BackgroundWhite
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun CategoryListScreen(
    navigateToMealsByCategory: (String) -> Unit,
    viewModel: CategoryListViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CategorListyHeader()
        }
    ) { paddingValues ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White,
                                BackgroundWhite,
                                BackgroundWhite
                            )
                        )),
                verticalArrangement = Arrangement.Top
            ) {
                CategoryListUi(
                    categoryList = uiState.categoryList,
                    onCategoryClicked = { category -> navigateToMealsByCategory(category) }
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
