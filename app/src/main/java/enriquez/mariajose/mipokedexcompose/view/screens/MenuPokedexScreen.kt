package enriquez.mariajose.mipokedexcompose.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import enriquez.mariajose.mipokedexcompose.R
import enriquez.mariajose.mipokedexcompose.model.data.getFavoritePokemons
import enriquez.mariajose.mipokedexcompose.view.components.FavoritesRow
import enriquez.mariajose.mipokedexcompose.view.components.PokedexGrid
import enriquez.mariajose.mipokedexcompose.model.data.pokemonList
import enriquez.mariajose.mipokedexcompose.ui.theme.Blue
import enriquez.mariajose.mipokedexcompose.ui.theme.Green
import enriquez.mariajose.mipokedexcompose.ui.theme.LightBlue
import enriquez.mariajose.mipokedexcompose.ui.theme.LightGreen
import enriquez.mariajose.mipokedexcompose.view.components.PokemonCell
import enriquez.mariajose.mipokedexcompose.view.components.PokemonRow

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id: Int) -> Unit) {
    var grid by remember { mutableStateOf(false) }

    Column(Modifier.padding(innerPadding)) {
        Text(
            text = "Favorite Pokemon",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)

        Spacer(Modifier.size(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("All Pokemons")

            Switch(
                checked = grid,
                onCheckedChange = { grid = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Transparent
                ),
                thumbContent = if (grid) {
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.grid_icon),
                            contentDescription = "grid icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                } else {
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.list_icon),
                            contentDescription = "list icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                }
            )
        }
        if (grid) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                items(pokemonList) { pokemon ->
                    PokemonCell(
                        pokemon = pokemon,
                        onNavigateToDetail = onNavigateToDetail
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pokemonList) { pokemon ->
                    PokemonRow(
                        pokemon = pokemon,
                        onNavigateToDetail = onNavigateToDetail
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuPokedexScreenPreview() {
    MenuPokedexScreen(PaddingValues(10.dp, 15.dp), {})
}