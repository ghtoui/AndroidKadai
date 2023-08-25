package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.DiceViewModel
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.foundation.layout.Spacer as Spacer
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun AppTopBar(
    iconButtonClick: () -> Unit,
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
                    text = "Dice App"
                )
                IconButton(
                    onClick = { iconButtonClick() }
                ) {
                    Icon(
                        Icons.Filled.Refresh,
                        contentDescription = null
                    )
                }
            }
        })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview
@Composable
fun DiceRollerApp(
    viewModel: DiceViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            AppTopBar(iconButtonClick =  viewModel::reset)
        }
    ) { it ->
        DiceWithButtonAndImage(
            imageResource = uiState.diceImage,
            clickButton = viewModel::clickButton,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun DiceWithButtonAndImage(
    @DrawableRes imageResource: Int,
    clickButton: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
// composable はステートレスだかららしい
// この書き方だと、値が保持されないため、切り替えることができない
//    var result = 1
// rememberを使うことで、保持できるようにする
    //------------
    // viewModelにするとこれもいらない
    //------------
//    var result by remember { mutableStateOf(1) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            clickButton()
        }) {
            Text(stringResource(R.string.roll))
        }
    }

}