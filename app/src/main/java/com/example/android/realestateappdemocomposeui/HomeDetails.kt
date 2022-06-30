package com.example.android.realestateappdemocomposeui

import androidx.compose.ui.graphics.vector.ImageVector

/** Basic classes to model house-related data */
data class Facility(
    val count: Int,
    val typeContentDesc: Int,
    val typeIcon: ImageVector
)
/**@param homeId used to match the relevant house gallery*/
data class HomeViewPrice(
    val homeFront:Int,
    val homePrice:String,
    val homeId:Int = 0
)
