package enriquez.mariajose.mipokedexcompose.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon
import enriquez.mariajose.mipokedexcompose.model.preferences.PokemonSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer,
    scope = CoroutineScope(
        Dispatchers.IO
    )
)

class CompanionPreferences(private val context: Context) {
    suspend fun saveCompanion(companion: Pokemon) {
        context.dataStore.updateData {
            pokemon -> companion
        }
    }
    fun pokemonCompanion(): Flow<Pokemon> = context.dataStore.data.map {
        pokemon -> pokemon
    }
}