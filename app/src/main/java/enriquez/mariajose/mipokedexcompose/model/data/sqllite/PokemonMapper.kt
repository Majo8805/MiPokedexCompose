package enriquez.mariajose.mipokedexcompose.model.data.sqllite

import android.content.ContentValues
import android.database.Cursor
import androidx.core.database.getFloatOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import enriquez.mariajose.mipokedexcompose.R
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon

class PokemonMapper {
    fun getPokemon(cursor: Cursor): Pokemon {
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NAME))
        val num = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NUMBER))
        val type = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_TYPE))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_DESCRIPTION))
        val height = cursor.getFloatOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_HEIGHT))
        val weight = cursor.getFloatOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_WEIGHT))
        val favorite = cursor.getIntOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_FAVORITE))
        val ability = cursor.getStringOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_ABILITY))
        val image = cursor.getBlob(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_IMAGE))

        return Pokemon(
            name = name,
            number = num,
            type = type,
            description = description,
            height = height ?: 0F,
            weight = weight ?: 0F,
            favorite = if (favorite==null || favorite == 0) false else true,
            ability = ability ?: "",
            image = R.drawable.wtp,
            sqlImage = image
        )

    }

    fun getContentValues(pokemon: Pokemon): ContentValues {
        val values = ContentValues().apply {
            put(Contract.Pokemons.COLUMN_NAME_NAME, pokemon.name)
            put(Contract.Pokemons.COLUMN_NAME_NUMBER, pokemon.number)
            put(Contract.Pokemons.COLUMN_NAME_TYPE, pokemon.type)
            put(Contract.Pokemons.COLUMN_NAME_DESCRIPTION, pokemon.description)
            put(Contract.Pokemons.COLUMN_NAME_HEIGHT, pokemon.height)
            put(Contract.Pokemons.COLUMN_NAME_WEIGHT, pokemon.weight)
            put(Contract.Pokemons.COLUMN_NAME_FAVORITE, pokemon.favorite)
            put(Contract.Pokemons.COLUMN_NAME_ABILITY, pokemon.ability)
            put(Contract.Pokemons.COLUMN_NAME_IMAGE, pokemon.image)
        }
        return values
    }
}