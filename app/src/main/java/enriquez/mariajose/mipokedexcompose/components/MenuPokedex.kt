package enriquez.mariajose.mipokedexcompose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import enriquez.mariajose.mipokedexcompose.domain.Pokemon
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(innerPadding)
    ) {
        items(pokemonList) {
            pokemon -> PokemonRow(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {

}