package enriquez.mariajose.mipokedexcompose.model.data.sqllite

import enriquez.mariajose.mipokedexcompose.model.data.interfaces.IPokemonDAO
import enriquez.mariajose.mipokedexcompose.model.data.interfaces.IPokemonRepository
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon

class PokemonSQLRepository(
    private val pokemonDAO: IPokemonDAO
) : IPokemonRepository {

    override suspend fun addPokemon(pokemon: Pokemon) {
        pokemonDAO.insertPokemon(pokemon)
    }

    override suspend fun getPokemons(): List<Pokemon> =
        pokemonDAO.getAllPokemons()

    override suspend fun getFavoritePokemons(): List<Pokemon> =
        pokemonDAO.getFavoritePokemons()

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return pokemonDAO.getPokemonByType(type)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        pokemonDAO.updatePokemon(pokemon)
    }

    override suspend fun deletePokemon(id: Integer) {
        pokemonDAO.getPokemonById(id)?.let { pokemonDAO.deletePokemon(it) }
    }

}