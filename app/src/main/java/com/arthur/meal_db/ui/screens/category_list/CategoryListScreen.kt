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
    navigateToMealDetail: (String) -> Unit,
    navigateToMealsByCategory: (String) -> Unit,
    viewModel: CategoryListViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) { viewModel.getRandomMeal() }

    var hideKeyboard by remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if(uiState.activeSearch){
                SearchBar(
                    hideKeyboard = hideKeyboard,
                    onFocusClear = { hideKeyboard = false },
                    onBack = {
                        viewModel.clearQuery()
                        viewModel.clearFinderResult()
                        viewModel.setActiveSearchState(false)
                        //viewModel.getTvShowList()
                    },
                    onWriteQuery = { query -> viewModel.searchMeal(query) }
                )
            } else {
                CategorListyHeader(
                    onSearchClicked = {
                        viewModel.setActiveSearchState(true)
                    }
                )
            }
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
                        )
                    ),
                verticalArrangement = Arrangement.Top
            ) {
                if(uiState.activeSearch){
                    MealByCategoryList(
                        mealList = uiState.mealList,
                        onMealClicked = { navigateToMealDetail(it) }
                    )
                } else {
                    SurpriseMe(
                        mealList = uiState.randomMealList,
                        onMealClicked = { navigateToMealDetail(it) }
                    )
                    CategoryListUi(
                        categoryList = uiState.categoryList,
                        onCategoryClicked = { category -> navigateToMealsByCategory(category) }
                    )
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
