package com.arthur.meal_db.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arthur.meal_db.R
import com.arthur.meal_db.ui.theme.DarknesBlueGray

@Composable
fun NoRegisters(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_no_register),
                contentDescription = null,
                modifier = Modifier.requiredSize(180.dp)
            )
            Text(
                text = stringResource(id = R.string.no_results_issue),
                style = MaterialTheme.typography.body1,
                color = DarknesBlueGray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }

}