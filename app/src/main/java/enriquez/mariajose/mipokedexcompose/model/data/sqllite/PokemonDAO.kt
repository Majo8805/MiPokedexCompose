package enriquez.mariajose.mipokedexcompose.model.data.sqllite

import enriquez.mariajose.mipokedexcompose.model.data.interfaces.IPokemonDAO
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDAO(private val databaseHelper: DatabaseHelper) : IPokemonDAO {
    private val mapper = PokemonMapper()
    override suspend fun insertPokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO){
            val db = databaseHelper.writableDatabase
            db.insert(Contract.Pokemons.TABLE_NAME, null, mapper.getContentValues(pokemon))
            db.close()
        }
    }

    override suspend fun getAllPokemons(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME}"

            val cursor = db.rawQuery(query, null)
            cursor.use {
                c ->
                buildList {
                    while (c.moveToNext()) {
                        add(mapper.getPokemon(cursor))
                    }
                }
            }
        }
    }

    override suspend fun getPokemonById(id: Integer): Pokemon? {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_ID} = ?"

            val cursor = db.rawQuery(query, arrayOf(id.toString()))
            cursor.use {
                c ->
                if (c.moveToFirst()) {
                    mapper.getPokemon(cursor)
                } else {
                    null
                }
            }
        }
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonByType(type: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_NAME_TYPE} = ?"

            val cursor = db.rawQuery(query, arrayOf(type))
            cursor.use {
                c ->
                buildList {
                    while (c.moveToNext()) {
                        add(mapper.getPokemon(cursor))
                    }
                }
            }
        }
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = databaseHelper.writableDatabase
            db.update(
                Contract.Pokemons.TABLE_NAME,
                mapper.getContentValues(pokemon),
                "${Contract.Pokemons.COLUMN_ID} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = databaseHelper.writableDatabase
            db.delete(
                Contract.Pokemons.TABLE_NAME,
                "${Contract.Pokemons.COLUMN_ID} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }


}