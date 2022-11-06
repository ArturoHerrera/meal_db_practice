package com.arthur.meal_db.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
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
import com.arthur.meal_db.data.model.CategorySimple
import com.arthur.meal_db.ui.theme.DarknesBlueGray
import com.arthur.meal_db.ui.theme.YellowDelicious


@Composable
fun CategoryListUi(
    categoryList: List<CategorySimple>,
    onCategoryClicked: (String) -> Unit
) {
    if (categoryList.isEmpty()) {
        NoRegisters()
    } else {
        LazyVerticalGrid(
            state = rememberLazyGridState(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(categoryList) { category ->
                CategoryItem(
                    category = category,
                    onCategoryClicked = { onCategoryClicked(it) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem(
    category: CategorySimple,
    onCategoryClicked: (String) -> Unit
) {
    Card(
        elevation = 16.dp,
        shape = RoundedCornerShape(24.dp),
        backgroundColor = YellowDelicious,
        onClick = { onCategoryClicked(category.category ?: "-na") },
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(
            //modifier = Modifier.background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(category.categoryThumb)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_no_image),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    filterQuality = FilterQuality.High,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .matchParentSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 0.0f,
                                    topEnd = 0.0f,
                                    bottomEnd = 16.0f,
                                    bottomStart = 16.0f
                                )
                            )
                            .background(Color.White),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = category.category?.uppercase() ?: "--",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 18.sp,
                            maxLines = 2,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            color = DarknesBlueGray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategorListyHeader() {
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
            text = "Hello, \uD83D\uDE0B",
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            color = DarknesBlueGray,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            text = "Greetings!",
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)
        )
        Text(
            color = DarknesBlueGray,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            text = "What would you like to cook today? \uD83E\uDDD1\u200D\uD83C\uDF73",
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
        )
    }
}