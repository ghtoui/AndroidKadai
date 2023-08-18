@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroApp() {
    HeroList(heroList = HeroesRepository.heroes)
}

@Composable
fun HeroList(heroList: List<Hero> , modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            HeroAppTopBar()
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(heroList) {
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun HeroAppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth()
                .height(72.dp)
        ) {
           Column(
               modifier = Modifier
                   .weight(1f)
           ) {
               Text(
                   text = stringResource(id = hero.nameRes),
                   style = MaterialTheme.typography.displaySmall
               )
               Text(
                   text = stringResource(id = hero.descriptionRes),
                   style = MaterialTheme.typography.bodyLarge
               )
           }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
            Image(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .height(72.dp)
                    .width(72.dp),
                contentScale = ContentScale.Crop,

                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.nameRes)
            )
        }
    }
}

@Preview
@Composable
fun SuperHeroPreview() {
    // ここでもちゃんとテーマを設定してあげないとプレビューに反映されない
    // ここで1時間くらい詰まった
    SuperHeroTheme(darkTheme = true) {
        HeroApp()
    }
}