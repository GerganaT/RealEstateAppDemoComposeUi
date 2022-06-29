package com.example.android.realestateappdemocomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        content()
    }
}


@Composable
fun PropertyCardContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(width = 192.dp)
            .padding(8.dp)
    ) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Image(
                painter = painterResource(R.drawable.house_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(88.dp)
            )
        }

        Row {
            Text(
                text = "Beautiful home 1 ",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "$560,000",
                style = MaterialTheme.typography.h3,
            )
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