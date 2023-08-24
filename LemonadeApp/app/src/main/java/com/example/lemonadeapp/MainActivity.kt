@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.lemonadeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.LemonViewModel
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Lemonade() {
    LemonadeApp()
}

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LemonadeApp(
    viewModel: LemonViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold (
        topBar = {
            LemonTopBar(
                clickEvent = viewModel::reset
            )
        }
    ) {
        LemonadeImageAndText(
            textResource = uiState.text,
            imageResource = uiState.image,
            imageClick = { viewModel.updateState(count = null) }
        )
    }
}

@Composable
fun LemonTopBar(
    clickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier)
                Text(
                    text = stringResource(id = R.string.lemon),
                    modifier = Modifier
                )
//                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable{
                            clickEvent()
                        }
                )
            }
        }
    )
}

@Composable
fun LemonadeImageAndText(
    textResource: Int,
    imageResource: Int,
    imageClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .wrapContentSize(Alignment.Center)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            stringResource(textResource),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    imageClick()
                }
                // これで枠線つけれる
                .border(
                    width = 2.dp,
                    color = Color.Cyan,
                    shape = RoundedCornerShape(20.dp)
                )
        )
    }
}