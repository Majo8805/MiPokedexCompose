package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon

class PokemonViewModel : ViewModel() {

    var wildPokemon by mutableStateOf<Pokemon?>(null)

    fun capturePokemon(){

    }
}