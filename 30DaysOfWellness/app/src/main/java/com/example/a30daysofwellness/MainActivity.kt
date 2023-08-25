package com.example.a30daysofwellness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysofwellness.model.KihonJouhou
import com.example.a30daysofwellness.model.KihonJouhouRepository
import com.example.a30daysofwellness.ui.WellnessViewModel
import com.example.a30daysofwellness.ui.theme._30DaysOfWellnessTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysOfWellnessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun WellnessApp(
    viewModel: WellnessViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            WellnessTopAppBar(
                refreshIconClick = viewModel::reset
            )
        }
    ) { it ->
        WellnessList(
            viewModel = viewModel,
            kihonJouhouList = uiState.kihonJouhouList,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessList(
    viewModel: WellnessViewModel,
    kihonJouhouList: List<KihonJouhou>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(kihonJouhouList) { kihonJouhou ->
            WellnessItem(
                kihonJouhou = kihonJouhou,
                itemClick = viewModel::itemClick,
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTopAppBar(
    refreshIconClick: () -> Unit,
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
                    text = stringResource(R.string._30_days_of_wellness)
                )
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable{
                            refreshIconClick()
                        }
                )
            }
        }
    )
}

@Composable
fun WellnessItem(
    kihonJouhou: KihonJouhou,
    itemClick: (item: KihonJouhou) -> Unit,
    modifier: Modifier = Modifier) {

    Card(modifier = modifier
        .clickable(
            onClick = { itemClick(kihonJouhou) }
        )
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            WellnessQuestion(questionId = kihonJouhou.question)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height)))
            WellnessQuestionImage(
                questionImageId = kihonJouhou.questionImage,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height)))
            // タップで切り替えれるように
            if (kihonJouhou.isVisible) WellnessAnswer(answerId = kihonJouhou.answer)
        }
    }
}

@Composable
fun WellnessAnswer(answerId: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = answerId),
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
    )
}

@Composable
fun WellnessQuestion(questionId: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(questionId),
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
    )
}

@Composable
fun WellnessQuestionImage(questionImageId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = questionImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@ExperimentalMaterial3Api
@Preview()
@Composable
fun WellnessPreview() {
    _30DaysOfWellnessTheme {
        WellnessApp()
    }
}