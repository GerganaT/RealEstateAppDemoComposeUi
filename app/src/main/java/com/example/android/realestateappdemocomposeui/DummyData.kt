package com.example.android.realestateappdemocomposeui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bathtub
import androidx.compose.material.icons.outlined.BedroomParent
import androidx.compose.material.icons.outlined.Grid4x4

/**This contains the dummy data,shown in the list*/

val bedrooms = Facility(
    R.string.bedrooms_count_default,
    R.string.content_desc_bedrooms_count,
    Icons.Outlined.BedroomParent
)

val bathrooms = Facility(
    R.string.bathrooms_count_default,
    R.string.content_desc_bathrooms_count,
    Icons.Outlined.Bathtub
)
val livingSpace = Facility(
    R.string.square_feet,
    R.string.content_desc_space_in_square_feet,
    Icons.Outlined.Grid4x4
)

val amenities = listOf(bedrooms, bathrooms, livingSpace)


val house1colapsed = HomeViewPrice(
    R.drawable.house1,
    "$540,000",
     1
)
val house2colapsed = HomeViewPrice(
    R.drawable.house2,
    "$399,999",
    2
)

val house3colapsed = HomeViewPrice(
    R.drawable.house3,
    "$455,555",
    3
)

val house4colapsed = HomeViewPrice(
    R.drawable.house4,
    "$488,888",
    4
)
val house5colapsed = HomeViewPrice(
    R.drawable.house5,
    "$667,477",
    5
)
val house6colapsed = HomeViewPrice(
    R.drawable.house6,
    "$789,999",
    6
)

val colapsedHouses = listOf(
    house1colapsed,
    house2colapsed,
    house3colapsed,
    house4colapsed,
    house5colapsed,
    house6colapsed
)

val galleryHouse1 = listOf(
    R.drawable.bedroom1,
    R.drawable.kitchen1,
    R.drawable.living1,
    R.drawable.backyard1
)
val galleryHouse2 = listOf(
    R.drawable.bedroom2,
    R.drawable.kitchen2,
    R.drawable.living2,
    R.drawable.backyard2
)
val galleryHouse3 = listOf(
    R.drawable.bedroom3,
    R.drawable.kitchen3,
    R.drawable.living3,
    R.drawable.backyard3
)
val galleryHouse4 = listOf(
    R.drawable.bedroom4,
    R.drawable.kitchen4,
    R.drawable.living4,
    R.drawable.backyard4
)
val galleryHouse5 = listOf(
    R.drawable.bedroom5,
    R.drawable.kitchen5,
    R.drawable.living5,
    R.drawable.backyard5
)
val galleryHouse6 = listOf(
    R.drawable.bedroom6,
    R.drawable.kitchen6,
    R.drawable.living6,
    R.drawable.backyard6
)