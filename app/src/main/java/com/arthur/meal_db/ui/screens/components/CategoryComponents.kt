package com.arthur.meal_db.ui.screens.components

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
import com.arthur.meal_db.data.model.CategorySimple
import kotlin.random.Random


@Composable
fun CategoryListUi(
    categoryList: List<CategorySimple>,
    onCategoryClicked: (String) -> Unit
) {
    CategoryHeader()
    if (categoryList.isEmpty()) {
        NoRegisters()
    } else {
        LazyVerticalGrid(
            state = rememberLazyGridState(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
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
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)),
        onClick = { onCategoryClicked(category.category ?: "-na") }
    ) {
        Column(
            //modifier = Modifier.background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(150.dp)
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
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent,
                                    Color.Transparent,
                                    Color.Black,
                                )
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .matchParentSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = category.category ?: "--",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.ExtraBold,
                            lineHeight = 18.sp,
                            maxLines = 2,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun CategoryHeader(

) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            text = "Categorias",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}