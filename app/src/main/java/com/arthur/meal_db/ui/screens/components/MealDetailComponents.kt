package com.arthur.meal_db.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Source
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthur.meal_db.R
import com.arthur.meal_db.data.model.MealDetailSimple
import com.arthur.meal_db.ui.theme.DarknesBlueGray
import de.charlex.compose.HtmlText

@Composable
fun MealDetailHeader(
    mealDetail: MealDetailSimple,
    onYtVideo: (String) -> Unit,
    onSource: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mealDetail.mealThumb)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_no_image),
                contentDescription = null,
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Black,
                            )
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = mealDetail.mealName ?: "--",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 18.sp,
                        maxLines = 3,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(end = 8.dp, bottom = 16.dp)
                                .clickable {
                                    if (mealDetail.urlYoutube.isNotBlank() && mealDetail.urlYoutube != "--") {
                                        onYtVideo(mealDetail.urlYoutube)
                                    }
                                }
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 8.dp),
                                text = "yt video",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Light,
                                lineHeight = 18.sp,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                            Icon(
                                imageVector = Icons.Filled.PlayCircle,
                                contentDescription = "Botón para visitar el sitio del show.",
                                tint = Color.White
                            )
                        }

                        if (mealDetail.area != "--") {
                            Row(
                                modifier = Modifier
                                    .padding(end = 8.dp, bottom = 16.dp)
                                    .weight(1f)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp),
                                    text = "area: ${mealDetail.area.lowercase()}",
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Light,
                                    lineHeight = 18.sp,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .padding(end = 8.dp, bottom = 16.dp)
                                .clickable {
                                    if (mealDetail.source.isNotBlank() && mealDetail.source != "--") {
                                        onSource(mealDetail.source)
                                    }
                                }
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp),
                                text = "source",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Light,
                                lineHeight = 18.sp,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                            Icon(
                                imageVector = Icons.Filled.Source,
                                contentDescription = "Botón para visitar el sitio del show.",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MealInstructions(mealDetail: MealDetailSimple) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = "Instructions:",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 18.sp,
            maxLines = 3,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            color = DarknesBlueGray
        )
        HtmlText(
            modifier = Modifier
                .fillMaxWidth(),
            text = mealDetail.instructions.trim().ifBlank { "--" },
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Light,
            lineHeight = 22.sp,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            color = DarknesBlueGray
        )
    }
}

@Composable
fun IngredientsList(ingredientList: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = "Ingredients:",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 18.sp,
            maxLines = 3,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            color = DarknesBlueGray
        )
        ingredientList.forEach {
            IngredientItem(
                ingredient = it
            )
        }
    }
}

@Composable
fun IngredientItem(ingredient: String) {
    Text(
        color = DarknesBlueGray,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        text = "\uD83D\uDD2A $ingredient",
        modifier = Modifier.fillMaxWidth()
    )
}