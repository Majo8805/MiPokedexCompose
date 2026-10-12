package enriquez.mariajose.mipokedexcompose.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import enriquez.mariajose.mipokedexcompose.viewModel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues, viewModel: PokemonViewModel = viewModel()) {
    Column(Modifier.fillMaxWidth().padding()) {
        Button({ viewModel.searchPokemon() }) {

        }
        viewModel.wildPokemon.let {
            pokemon ->
            Text("Aparecio un ${pokemon.name} salvaje")

        }
    }
}