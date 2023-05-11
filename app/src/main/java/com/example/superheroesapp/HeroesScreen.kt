package com.example.superheroesapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.superheroesapp.model.Hero

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
Card(modifier = modifier) {
    Row() {
        Column {

        }
    }
}
}

@Composable
fun HeroInformation(
    @StringRes nameHero: Int,
    @StringRes descriptionHero: Int
) {

}