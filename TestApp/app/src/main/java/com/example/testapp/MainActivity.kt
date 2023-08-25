package com.example.testapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.TestViewModel
import com.example.testapp.ui.theme.TestAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestApp()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TestApp(
    viewModel: TestViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TestLayout(time = uiState.time,
            clickEvent = viewModel::getDiffTime)
    }
}

@Composable
fun TestLayout(
    clickEvent: () -> Unit,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Test App",
            fontSize = 64.sp
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_large)))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_large)))
        TestTool(clickEvent = clickEvent)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_large)))
        CountTimer(time = time)
    }
}

@Composable
fun CountTimer(
    time: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "time"
    )
    Text(
        text = time,
        fontSize = 32.sp
    )
}

@Composable
fun TestTool(
    clickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            IconLayout(iconImage = Icons.Filled.Delete, onClickEvent = { clickEvent() })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_min)))
            IconLayout(iconImage = Icons.Filled.Email, onClickEvent = {})
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_min)))
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_min)))
        Row() {
            IconLayout(iconImage = Icons.Filled.Add, onClickEvent = {})
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_min)))
            IconLayout(iconImage = Icons.Filled.Call, onClickEvent = {})
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_min)))
            IconLayout(iconImage = Icons.Filled.DateRange, onClickEvent = {})
        }

    }
}

@Composable
fun IconLayout(
    iconImage: ImageVector,
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
        .height(dimensionResource(id = R.dimen.icon_size))
        .width(dimensionResource(id = R.dimen.icon_size))
        .border(
            width = 2.dp,
            color = Color.Red,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.icon_shape))
        )
        .background(
            color = Color.DarkGray,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.icon_shape))
        )
) {
    IconButton(onClick = { onClickEvent() },
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.icon_size))
            .height(dimensionResource(id = R.dimen.icon_size))) {
        Icon(
            iconImage,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        TestApp()
    }
}