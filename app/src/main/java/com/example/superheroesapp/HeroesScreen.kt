package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        // подъем карты над основыным слоем
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }

    }
}

@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        itemsIndexed(heroes) { index, hero ->
            HeroItem(
                hero = hero,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroItemPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme() {
        HeroItem(hero = hero)
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesListPreview() {
    SuperheroesTheme() {
        Surface(color = MaterialTheme.colorScheme.background) {
            HeroesList(heroes = HeroesRepository.heroes)
        }

    }
}
    


