package com.example.a30daysofwellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofwellness.model.KihonJouhou
import com.example.a30daysofwellness.model.KihonJouhouRepository
import com.example.a30daysofwellness.ui.theme._30DaysOfWellnessTheme

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

@Composable
fun WellnessApp() {
    WellnessList(kihonJouhouList = KihonJouhouRepository.KihonJouhouList)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessList(kihonJouhouList: List<KihonJouhou>) {
    Scaffold(
        topBar = {
            WellnessTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(kihonJouhouList) { kihonJouhou ->
                WellnessItem(
                    kihonJouhou = kihonJouhou,
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium),
                            bottom = dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days Of Wellness"
            )
        }
    )
}

@Composable
fun WellnessItem(kihonJouhou: KihonJouhou, modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(false) }
    Card(modifier = modifier
        .clickable(
            onClick = { isVisible = !isVisible }
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
            if (isVisible) WellnessAnswer(answerId = kihonJouhou.answer)
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

@Preview()
@Composable
fun WellnessPreview() {
    _30DaysOfWellnessTheme {
        WellnessApp()
    }
}