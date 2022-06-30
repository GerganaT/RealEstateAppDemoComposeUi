package com.example.android.realestateappdemocomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.realestateappdemocomposeui.ui.theme.RealEstateAppDemoComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitializeScreen("Android")
        }
    }
}

@Composable
fun InitializeScreen(name: String) {
    RealEstateAppDemoComposeUiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Text(text = "Hello $name!")
        }
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
    ) {
        content()
    }
}


@Composable
fun PropertyCardContent(modifier: Modifier = Modifier) {

    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .width(width = 192.dp)
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Image(
                painter = painterResource(R.drawable.house_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(88.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "$560,000",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { expanded = !expanded }
            ) {
                Icon(
                    imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                    tint = Color.Black,
                    contentDescription =
                    if (expanded) stringResource(R.string.content_desc_show_less)
                    else stringResource(R.string.content_desc_show_more),

                    )
            }
        }

    }

}




@Preview(showBackground = true)
@Composable
fun PropertyContentPreview() {
    RealEstateAppDemoComposeUiTheme {
        PropertyCardContent()

    }
}

@Preview(showBackground = true)
@Composable
fun PropertyCardAndContentPreview() {
    RealEstateAppDemoComposeUiTheme {
        PropertyCard(
            modifier = Modifier.padding(16.dp)
        ) {
            PropertyCardContent()
        }
    }
}