package com.arthur.meal_db.ui.screens.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.arthur.meal_db.ui.theme.MainGreen

@Composable
fun ErrorAlert(errorMsg: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "¡Upps! Parece que hubo un problema", color = MainGreen)
        },
        text = {
            Text(text = errorMsg, color = Color.Black)
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = "Aceptar",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}