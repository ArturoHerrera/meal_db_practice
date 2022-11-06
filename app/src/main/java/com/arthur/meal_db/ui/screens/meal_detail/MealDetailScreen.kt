package com.arthur.meal_db.ui.screens.meal_detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthur.meal_db.ui.screens.components.*
import com.arthur.meal_db.ui.theme.BackgroundWhite
import com.arthur.meal_db.R
import com.arthur.meal_db.utils.IntentUtils.openExternalUrl
import com.arthur.meal_db.utils.IntentUtils.openYtVideo

@Composable
fun MealDetailScreen(
    upPress: () -> Unit,
    viewModel: MealDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    val context = LocalContext.current

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
                uiState.mealDetail?.let { safeDetail ->
                    MealDetailHeader(
                        mealDetail = safeDetail,
                        onYtVideo = { ytVideoLink ->
                            openYtVideo(
                                ytVideoLink = ytVideoLink,
                                context = context
                            )
                        },
                        onSource = {url ->
                            openExternalUrl(
                                externalUrl = url,
                                context = context
                            )
                        }
                    )
                    if (safeDetail.ingredientList.isNotEmpty()) {
                        IngredientsList(safeDetail.ingredientList)
                    }
                    MealInstructions(safeDetail)
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
