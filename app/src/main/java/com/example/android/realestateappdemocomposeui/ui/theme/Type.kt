package com.example.android.realestateappdemocomposeui.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.android.realestateappdemocomposeui.R

private val fontFamilyRaleway = FontFamily(
    listOf(
        Font(
            resId = R.font.raleway_regular
        ),
        Font(
            resId = R.font.raleway_light,
            weight = FontWeight.Light
        )
    )
)


// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = fontFamilyRaleway,
    h3 = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 0.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)