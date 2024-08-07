package com.example.housesorter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.housesorter.ui.theme.HouseSorterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SortingHouseApp()
        }
    }
}

@Composable
fun HouseSortingAndImages(
    imageResource: Int,
    contentDescriptor: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = contentDescriptor
        )
        Button(onClick = { onClick() }) {
            Text(text = stringResource(R.string.allegianc_text))
        }
    }
}

@Composable
fun SortingHouseApp() {
    var house by remember { mutableStateOf("Sorting Hat") }
    var imageResource by remember { mutableStateOf(R.drawable.sorter) }

    val houseNames = listOf("Stark", "Targaryen", "Arryn", "Lannister")
    val houseImages = listOf(
        R.drawable.stark,
        R.drawable.targeryen,
        R.drawable.arryn,
        R.drawable.lannister
    )

    fun sortHouse() {
        val randomNumber = (1..999).random()
        val houseIndex = randomNumber % 4
        house = houseNames[houseIndex]
        imageResource = houseImages[houseIndex]
    }

    HouseSortingAndImages(
        imageResource = imageResource,
        contentDescriptor = house,
        modifier = Modifier,
        onClick = { sortHouse() }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HouseSorterTheme {
        SortingHouseApp()
    }
}
