package enriquez.mariajose.mipokedexcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import enriquez.mariajose.mipokedexcompose.components.FavoritesRow
import enriquez.mariajose.mipokedexcompose.components.PokedexGrid
import enriquez.mariajose.mipokedexcompose.data.pokemonList
import enriquez.mariajose.mipokedexcompose.domain.Pokemon
import enriquez.mariajose.mipokedexcompose.ui.theme.Typography

@Composable
fun MenuPokedexScreen(
    pokemonList: List<Pokemon>,
    favoriteList: List<Pokemon>,
    innerPadding: PaddingValues
) {
    Column(modifier = Modifier.padding(innerPadding)) {
        Text(
            text = "Mis Favoritos",
            style = Typography.titleLarge,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 5.dp)
        )
        FavoritesRow(favoriteList = favoriteList)
        Text(
            text = "Todos mis Pokemon",
            style = Typography.titleLarge,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 5.dp)
        )
        PokedexGrid(pokemonList = pokemonList)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuPokedexScreenPreview() {
    MenuPokedexScreen(
        pokemonList = pokemonList,
        favoriteList = pokemonList.filter { it.favorite },
        innerPadding = PaddingValues(0.dp)
    )
}
