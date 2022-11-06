package com.arthur.meal_db.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthur.meal_db.R
import com.arthur.meal_db.data.model.CategorySimple
import com.arthur.meal_db.data.model.MealCoverSimple
import com.arthur.meal_db.ui.theme.DarknesBlueGray
import com.arthur.meal_db.ui.theme.YellowDelicious
import com.arthur.meal_db.utils.EmojiUtils

@Composable
fun CategoryListUi(
    categoryList: List<CategorySimple>,
    onCategoryClicked: (String) -> Unit
) {
    if (categoryList.isEmpty()) {
        NoRegisters()
    } else {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
            text = "Categories:",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 18.sp,
            maxLines = 3,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            color = DarknesBlueGray
        )
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
fun CategorListyHeader(
    onSearchClicked: () -> Unit
) {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = DarknesBlueGray,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Greetings!"
            )
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Botón para buscar",
                tint = DarknesBlueGray,
                modifier = Modifier.clickable { onSearchClicked() }
            )
        }
        Text(
            color = DarknesBlueGray,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            text = "What would you like to cook today? ${EmojiUtils.randomCook()}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
        )
    }
}

@Composable
fun SurpriseMe(
    mealList: List<MealCoverSimple>,
    onMealClicked: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
            text = "Surprise recipe:",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 18.sp,
            maxLines = 3,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            color = DarknesBlueGray
        )
    }
    if (mealList.isNotEmpty()) {
        MealRandomItem(
            meal = mealList.first(),
            onMealClicked = { onMealClicked(it) }
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MealRandomItem(
    meal: MealCoverSimple,
    onMealClicked: (String) -> Unit
) {
    Card(
        elevation = 16.dp,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        backgroundColor = Color.White,
        onClick = { onMealClicked(meal.mealId ?: "-1") }
    ) {
        Row(
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
                    .height(150.dp)
                    .padding(16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = meal.mealName ?: "--",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 18.sp,
                    fontSize = 18.sp,
                    color = DarknesBlueGray
                )
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                ) {
                    Icon(
                        tint = YellowDelicious,
                        imageVector = Icons.Filled.ArrowCircleRight,
                        contentDescription = null,
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    onWriteQuery: (String) -> Unit,
    onFocusClear: () -> Unit,
    onBack: () -> Unit,
    hideKeyboard: Boolean = false
) {
    var query by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester = focusRequester)
                .onFocusChanged { isHintDisplayed = it.hasFocus != true },
            value = query,
            onValueChange = { query = it },
            label = {
                Text(
                    text = "Buscar",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = DarknesBlueGray,
                textColor = DarknesBlueGray,
                disabledLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                onWriteQuery(query)
            }),
            maxLines = 1,
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {
                    if (query.isNotEmpty()) {
                        query = ""
                    } else {
                        focusManager.clearFocus()
                        onBack()
                    }
                }) {
                    if (query.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Botón para regresar",
                            tint = DarknesBlueGray
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Botón para regresar",
                            tint = DarknesBlueGray
                        )
                    }
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    focusManager.clearFocus()
                    onWriteQuery(query)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Botón para buscar",
                        tint = DarknesBlueGray
                    )
                }
            }
        )
    }

    if (hideKeyboard) {
        focusManager.clearFocus()
        onFocusClear()
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}