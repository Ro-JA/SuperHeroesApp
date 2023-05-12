package com.example.superheroesapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.superheroesapp.model.Hero

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
Card(modifier = modifier) {
    Row() {
        HeroInformation(nameHero = hero.nameRes, descriptionHero = hero.descriptionRes)
    }
}
}

@Composable
fun HeroInformation(
    @StringRes nameHero: Int,
    @StringRes descriptionHero: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = nameHero),
        style = MaterialTheme.typography.displayLarge)
        Text(text = stringResource(id = descriptionHero),
        style = MaterialTheme.typography.displayMedium)
    }
}