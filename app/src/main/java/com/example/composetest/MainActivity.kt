package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun JetPackCompose(firstText: String, secondText: String, thirdText: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Icon(
            painter = image,
            contentDescription = null
        )
        Text(
            text = firstText,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = secondText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = thirdText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun TaskManager(firstText: String, secondText: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = image,
            contentDescription = null
        )
        Text(
            text = firstText,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = secondText,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun QuadRant(firstTitle: String, firstDesc: String, secondTitle: String, secondDesc: String,
             thirdTitle: String, thirdDesc: String, forthTitle: String, forthDesc: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Cyan)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = firstTitle,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = firstDesc,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Yellow)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = secondTitle,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = secondDesc,
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row(Modifier.weight(1f)) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Cyan)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = thirdTitle,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = thirdDesc,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = forthTitle,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = forthDesc,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Composable
fun NameCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Box(
        modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
    ) {
        Column(
            modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier
                    .height(128.dp)
            )
            Text(
                text = "Mori toui",
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                text = "Summer Intern",
                fontSize = 32.sp,
                color = Color.Cyan
            )
        }
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            DetailProfile(image = image, text = stringResource(id = R.string.phone_number))
            DetailProfile(image = image, text = stringResource(id = R.string.email))
            DetailProfile(image = image, text = stringResource(id = R.string.address))
        }
    }
}

@Composable
fun DetailProfile(image: Painter, text: String, modifier: Modifier = Modifier) {
    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )
    Row {
        Icon(
            painter = image,
            contentDescription = null,
            modifier
                .height(32.dp)
                .padding(start = 64.dp),
            tint = Color.Cyan
        )
        Spacer(modifier.width(16.dp))
        Text(
            text = text,
            color = Color.Cyan
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        val firstText = stringResource(R.string.first_text)
        val secondText = stringResource(R.string.second_text)
        val thirdText = stringResource(R.string.third_text)

        val taskFirstText = stringResource(R.string.task_first_text)
        val taskSecondText = stringResource(R.string.task_second_ext)

        val quadFirstTitle = stringResource(R.string.first_title)
        val quadFirstDesc = stringResource(R.string.first_desc)
        val quadSecondTitle = stringResource(R.string.second_title)
        val quadSecondDesc = stringResource(R.string.second_desc)
        val quadThirdTitle = stringResource(R.string.third_title)
        val quadThirdDesc = stringResource(R.string.third_desc)
        val quadForthTitle = stringResource(R.string.forth_title)
        val quadForthDesc = stringResource(R.string.forth_desc)

//        JetPackCompose(firstText = firstText, secondText = secondText, thirdText = thirdText)
//        TaskManager(firstText = taskFirstText, secondText = taskSecondText)
//        QuadRant(
//            firstTitle = quadFirstTitle,
//            firstDesc = quadFirstDesc,
//            secondTitle = quadSecondTitle,
//            secondDesc = quadSecondDesc,
//            thirdTitle = quadThirdTitle,
//            thirdDesc = quadThirdDesc,
//            forthTitle = quadForthTitle,
//            forthDesc = quadForthDesc
//        )
        NameCard()
    }
}