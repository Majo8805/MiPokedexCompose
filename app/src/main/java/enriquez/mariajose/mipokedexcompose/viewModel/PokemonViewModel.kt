package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import enriquez.mariajose.mipokedexcompose.model.data.pokemonList
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon

class PokemonViewModel : ViewModel() {

    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set

    var capturedPokemon by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePokemon by mutableStateOf(false)

    fun searchPokemon(){
        wildPokemon = pokemonList.random()
    }

    fun capturePokemon(){
        wildPokemon?.let {
            var isCaptured = (1..2).random()
            if(isCaptured == 1){
                capturedPokemon = capturedPokemon + it
                gonePokemon = false
                wildPokemon = null
            } else {
                gonePokemon =true
                wildPokemon = null
            }
        }
    }
}