package enriquez.mariajose.mipokedexcompose.model.data.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """
                CREATE TABLE ${Contract.Pokemons.TABLE_NAME} (
                    ${Contract.Pokemons.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                    ${Contract.Pokemons.COLUMN_NAME_NUMBER} INTEGER NOT NULL,
                    ${Contract.Pokemons.COLUMN_NAME_NAME} TEXT NOT NULL,
                    ${Contract.Pokemons.COLUMN_NAME_DESCRIPTION} TEXT NOT NULL,
                    ${Contract.Pokemons.COLUMN_NAME_TYPE} TEXT NOT NULL
                )
            """.trimIndent()
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        if (db == null) return

        if (oldVersion < 2) {
            val addColumnAbility = "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} " +
                    "ADD COLUMN ${Contract.Pokemons.COLUMN_NAME_ABILITY} TEXT"
            val addColumnFavorite = "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} " +
                    "ADD COLUMN ${Contract.Pokemons.COLUMN_NAME_FAVORITE} BOOLEAN"
            val addColumnHeight = "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} " +
                    "ADD COLUMN ${Contract.Pokemons.COLUMN_NAME_HEIGHT} REAL"
            val addColumnWeight = "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} " +
                    "ADD COLUMN ${Contract.Pokemons.COLUMN_NAME_WEIGHT} REAL"
            val addColumnImage = "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} " +
                    "ADD COLUMN ${Contract.Pokemons.COLUMN_NAME_IMAGE} BLOB"
            db?.beginTransaction()
            db?.execSQL(addColumnAbility)
            db?.execSQL(addColumnFavorite)
            db?.execSQL(addColumnHeight)
            db?.execSQL(addColumnWeight)
            db?.execSQL(addColumnImage)
            db?.setTransactionSuccessful()
            db?.endTransaction()
        }
    }

    companion object{
        private const val  DATABASE_NAME = "pokedex.db"
        private const val DATABASE_VERSION = 2
    }
}