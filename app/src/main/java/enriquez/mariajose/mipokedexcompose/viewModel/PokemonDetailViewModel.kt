package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import enriquez.mariajose.mipokedexcompose.model.data.CompanionPreferences
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val companionDataStore: CompanionPreferences): ViewModel() {
    fun saveCompanion(pokemon: Pokemon) {
        viewModelScope.launch {
            companionDataStore.saveCompanion(pokemon)
        }
    }
}