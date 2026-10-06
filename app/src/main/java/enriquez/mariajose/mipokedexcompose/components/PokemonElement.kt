package enriquez.mariajose.mipokedexcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import enriquez.mariajose.mipokedexcompose.domain.Pokemon
import enriquez.mariajose.mipokedexcompose.ui.theme.Green
import enriquez.mariajose.mipokedexcompose.ui.theme.OffWhite
import enriquez.mariajose.mipokedexcompose.ui.theme.Typography
import enriquez.mariajose.mipokedexcompose.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = pokemon.name + " image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = Typography.labelLarge
            )
            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Height: " + pokemon.height,
                    style = Typography.labelMedium
                )
                Text(
                    text = "Weight: " + pokemon.weight,
                    style = Typography.labelMedium
                )
            }
        }
        val pokemonColors = getColorByType(pokemon.type)
        NumberChip(
            texto = pokemon.number.toString(),
            colors = pokemonColors,
            modifier = Modifier.align(Alignment.Top)
        )
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val pokemonColors = getColorByType(pokemon.type)
        Box() {
            Box(
                modifier = Modifier
                    .border(
                        border = BorderStroke(
                            width = 5.dp,
                            brush = Brush.sweepGradient(
                                colors = listOf(
                                    pokemonColors.first,
                                    OffWhite,
                                    pokemonColors.first,
                                    OffWhite,
                                    pokemonColors.first
                                )
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name + " image",
                    modifier = Modifier
                        .width(75.dp)
                        .padding(5.dp)
                )
            }
            NumberChip(
                texto = pokemon.number.toString(),
                colors = pokemonColors,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
        Text(
            text = pokemon.name,
            style = Typography.labelLarge
        )
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box() {
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name + " image",
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )
            val pokemonColors = getColorByType(pokemon.type)
            NumberChip(
                texto = pokemon.number.toString(),
                colors = pokemonColors,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
        Text(
            text = pokemon.name,
            style = Typography.labelLarge
        )
    }
}