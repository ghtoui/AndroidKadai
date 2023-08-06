package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                Lemonade()
            }
        }
    }
}

@Preview
@Composable
fun Lemonade() {
    LemonadeImageAndText()
}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier
    .fillMaxSize()
    .background(Color.White)
    .wrapContentSize(Alignment.Center)
) {
    var state by remember {
        mutableStateOf(0)
    }

    var count by remember {
        mutableStateOf(0)
    }

    var tappedCount by remember {
        mutableStateOf(0)
    }

    val imageResource = when(state % 4) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when(state % 4) {
        0 -> R.string.tap_lemon_tree
        1 -> R.string.keep_tapping_lemon
        2 -> R.string.tap_lemonade
        else -> R.string.tap_empty_glass
    }

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
                    // 単純な分岐はwhenの方が楽
                    when (state % 4) {
                        1 -> tappedCount++
                        else -> state++
                    }
                    if (state % 4 == 1 && tappedCount == 0) {
                        count = (2..4).random()
                    } else if (tappedCount == count) {
                        state++
                        tappedCount = 0
                    }
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