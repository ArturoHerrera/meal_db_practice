package com.arthur.meal_db.ui.screens.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arthur.meal_db.ui.theme.AplazoBlue

@Composable
fun ProgressBar(state: Boolean) {
    if(state){
        AnimatedVisibility(
            state,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().background(Color.Transparent)
            ){
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                    color = AplazoBlue,
                    backgroundColor = Color.Black.copy(alpha = 0.5f)
                )
            }
        }

    }
}