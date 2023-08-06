package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceLayoutPreview()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    var state by remember { mutableStateOf(0) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(32.dp)
                .border(
                    width = 2.dp,
                    color = Color.DarkGray
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(getImage(state)),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Spacer(Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp)
                .background(color = Color.LightGray)
        ) {
            Text(
                stringResource(id = getText(state)),
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 6.dp)
            )
            Text(
                "MORI TOUI (2023)",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 6.dp)
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        ButtonField(
            Modifier.padding(bottom = 16.dp),
            previewEvent = { state--; if (state == -1) { state = 6 }},
            nextEvent = { state++; if(state == 7) { state = 0 }}
        )
    }
}

@Composable
fun ButtonField(
    modifier: Modifier = Modifier,
    previewEvent: () -> Unit,
    nextEvent: () -> Unit
) {
    Row(
        modifier = modifier
    ) {
        Button(
            onClick = previewEvent
        ) {
            Text(
                "Preview"
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(
            onClick = nextEvent
        ) {
            Text(
                "Next"
            )
        }
    }
}

fun getImage(state: Int = 0): Int {
    return when(state) {
        0 -> R.drawable.dice_1
        1 -> R.drawable.ic_launcher_background
        2 -> R.drawable.lemon_tree
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_drink
        5 -> R.drawable.lemon_restart
        else -> R.drawable.ic_task_completed
    }
}

fun getText(state: Int = 0): Int {
    return when(state) {
        0 -> R.string.dice_1
        1 -> R.string.background
        2 -> R.string.lemon_tree
        3 -> R.string.lemon
        4 -> R.string.lemonade
        5 -> R.string.empty_glass
        else -> R.string.complete_task
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceLayout()
}