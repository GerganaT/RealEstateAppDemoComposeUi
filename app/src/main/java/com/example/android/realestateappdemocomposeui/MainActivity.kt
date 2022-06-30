package com.example.android.realestateappdemocomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.HolidayVillage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.realestateappdemocomposeui.ui.theme.RealEstateAppDemoComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitializeScreen()
        }
    }
}

@Composable
fun InitializeScreen() {
    RealEstateAppDemoComposeUiTheme {
        Scaffold(
            bottomBar = { RealEstateBottomNavigation()}
        ) { padding -> FavoritesScreen(Modifier.padding(padding))
        }


    }

}

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        HouseList()
    }
}

@Composable
fun PropertyCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(bottom = 8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        content()
    }
}


@Composable
fun PropertyCardContent(
    @DrawableRes houseUpfront: Int,
    housePrice: String,
    homeId: Int,
    modifier: Modifier = Modifier
) {

    var expanded by rememberSaveable { mutableStateOf(false) }
    val passedHomeId by rememberSaveable { mutableStateOf(homeId) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Image(
                painter = painterResource(houseUpfront),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(192.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = housePrice,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { expanded = !expanded }
            ) {
                Icon(
                    imageVector = if (expanded) Outlined.ExpandLess else Outlined.ExpandMore,
                    tint = Color.Black,
                    contentDescription =
                    if (expanded) stringResource(R.string.content_desc_show_less)
                    else stringResource(R.string.content_desc_show_more),

                    )
            }
        }
        if (expanded) ExpandedCardContent(homeIdentifier = passedHomeId)
    }

}

@Composable
fun ExpandedCardContent(
    homeIdentifier: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(bottom = 8.dp)) {
        Text(
            text = stringResource(R.string.description_headline),
            style = MaterialTheme.typography.h3
                .copy(textDecoration = TextDecoration.Underline),
            modifier = Modifier.paddingFromBaseline(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.real_estate_description_placeholder),
            style = MaterialTheme.typography.h4
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            amenities.forEach { facility ->
                facility.run {
                    PropertyFacilities(
                        facilityCount = count,
                        facilityTypeContentDesc = typeContentDesc,
                        facilityTypeIcon = typeIcon
                    )
                }

            }
        }
        Text(
            text = stringResource(R.string.gallery_label),
            style = MaterialTheme.typography.h3
                .copy(textDecoration = TextDecoration.Underline),
            modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
        )
        GalleryList(homeIdentifier = homeIdentifier)
    }
}

@Composable
fun PropertyFacilities(
    @StringRes facilityCount: Int,
    @StringRes facilityTypeContentDesc: Int,
    facilityTypeIcon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(end = 8.dp)
    ) {
        Icon(
            imageVector = facilityTypeIcon,
            contentDescription = stringResource(facilityTypeContentDesc),
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = stringResource(facilityCount),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(bottom = 8.dp)

        )
    }
}

@Composable
fun HouseList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        modifier = modifier
    ) {
        items(colapsedHouses) { item ->
            PropertyCard {
                PropertyCardContent(
                    item.homeFront,
                    item.homePrice,
                    item.homeId
                )
            }

        }
    }
}

@Composable
fun GalleryList(
    homeIdentifier: Int,
    modifier: Modifier = Modifier
) {
    val matchingGallery = when (homeIdentifier) {
        1 -> galleryHouse1
        2 -> galleryHouse2
        3 -> galleryHouse3
        4 -> galleryHouse4
        5 -> galleryHouse5
        6 -> galleryHouse6
        else -> listOf()
    }
    Column(modifier = modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(matchingGallery) { item ->
                GalleryItem(galleryImage = item)

            }

        }
    }
}

@Composable
fun GalleryItem(
    @DrawableRes galleryImage: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.size(width = 145.dp, height = 88.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(galleryImage),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.content_desc_gallery_item)
        )
    }
}

@Composable
private fun RealEstateBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black,
        modifier = modifier) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Outlined.Favorite,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_favorites))
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Outlined.HolidayVillage,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_all))
            })

    }
}

@Preview(showBackground = true)
@Composable
fun PropertyContentPreview() {
    RealEstateAppDemoComposeUiTheme {
        PropertyCardContent(
            R.drawable.house1,
            "$560,000",
            1
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PropertyCardAndContentPreview() {
    RealEstateAppDemoComposeUiTheme {
        PropertyCard(
            modifier = Modifier.padding(16.dp)
        ) {
            PropertyCardContent(
                houseUpfront = R.drawable.house1,
                "$560,000",
                1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandedCardContentPreview() {
    RealEstateAppDemoComposeUiTheme {
        ExpandedCardContent(1)
    }
}

@Preview(showBackground = true)
@Composable
fun RealEstateBottomNavigationPreview(){
    RealEstateAppDemoComposeUiTheme {
        RealEstateBottomNavigation()
    }
}

@Preview(showBackground = true,widthDp = 360, heightDp = 640)
@Composable
fun InitializeScreenPreview(){
    InitializeScreen()
}