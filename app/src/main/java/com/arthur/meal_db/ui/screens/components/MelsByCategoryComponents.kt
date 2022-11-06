package com.arthur.meal_db.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthur.meal_db.data.model.MealCoverSimple
import com.arthur.meal_db.ui.theme.DarknesBlueGray
import com.arthur.meal_db.utils.EmojiUtils
import com.arthur.meal_db.R
import com.arthur.meal_db.ui.theme.YellowDelicious

@Composable
fun MealsByCategoryListyHeader() {
    //TODO Move to resource strings.
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            color = DarknesBlueGray,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            text = "Come on,",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            color = DarknesBlueGray,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            text = "pick something delicious! ${EmojiUtils.randomCook()}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
        )
    }
}

@Composable
fun MealByCategoryList(
    mealList: List<MealCoverSimple>,
    onMealClicked: (String) -> Unit
){
    if (mealList.isEmpty()) {
        NoRegisters()
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(mealList) { meal ->
                MealItem(
                    meal = meal,
                    onMealClicked = { onMealClicked(it) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MealItem(
    meal: MealCoverSimple,
    onMealClicked: (String) -> Unit
){
    Card(
        elevation = 16.dp,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        onClick = { onMealClicked(meal.mealId ?: "-1") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .weight(3.5f)
                    .height(150.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxHeight(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(meal.mealImageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_no_image),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                modifier = Modifier
                    .weight(5.0f)
                    .padding(8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    text = meal.mealName ?: "--",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                    fontSize = 22.sp,
                    color = DarknesBlueGray
                )

            }
        }
    }
}

