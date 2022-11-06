package com.arthur.meal_db.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arthur.meal_db.R

val Slab = FontFamily(
    Font(R.font.nunito_extra_bold, FontWeight.ExtraBold),
    Font(R.font.nunito_semi_bold, FontWeight.SemiBold),
    Font(R.font.nunito_regular, FontWeight.Normal),
    Font(R.font.nunito_medium, FontWeight.Medium),
    Font(R.font.nunito_light, FontWeight.Light),
    Font(R.font.nunito_extra_light, FontWeight.ExtraLight)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Slab,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

