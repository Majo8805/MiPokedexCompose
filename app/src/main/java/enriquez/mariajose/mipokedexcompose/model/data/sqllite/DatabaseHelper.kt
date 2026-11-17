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
                    ${Contract.Pokemons.COLUMN_NAME_TYPE} TEXT NOT NULL,
                    ${Contract.Pokemons.COLUMN_NAME_HEIGHT} REAL NOT NULL DEFAULT 0,
                    ${Contract.Pokemons.COLUMN_NAME_WEIGHT} REAL NOT NULL DEFAULT 0,
                    ${Contract.Pokemons.COLUMN_NAME_FAVORITE} INTEGER NOT NULL DEFAULT 0,
                    ${Contract.Pokemons.COLUMN_NAME_ABILITY} TEXT NOT NULL DEFAULT '',
                    ${Contract.Pokemons.COLUMN_NAME_IMAGE} INTEGER NOT NULL DEFAULT -1
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
            val columns = db.rawQuery(
                "PRAGMA table_info(${Contract.Pokemons.TABLE_NAME})",
                null
            ).use { cursor ->
                buildSet {
                    val nameColumn = cursor.getColumnIndexOrThrow("name")
                    while (cursor.moveToNext()) {
                        add(cursor.getString(nameColumn))
                    }
                }
            }

            if (columns.isEmpty()) {
                onCreate(db)
            } else {
                val newColumns = listOf(
                    Contract.Pokemons.COLUMN_NAME_HEIGHT to "REAL NOT NULL DEFAULT 0",
                    Contract.Pokemons.COLUMN_NAME_WEIGHT to "REAL NOT NULL DEFAULT 0",
                    Contract.Pokemons.COLUMN_NAME_FAVORITE to "INTEGER NOT NULL DEFAULT 0",
                    Contract.Pokemons.COLUMN_NAME_ABILITY to "TEXT NOT NULL DEFAULT ''",
                    Contract.Pokemons.COLUMN_NAME_IMAGE to "INTEGER NOT NULL DEFAULT -1"
                )
                newColumns.forEach { (column, definition) ->
                    if (column !in columns) {
                        db.execSQL(
                            "ALTER TABLE ${Contract.Pokemons.TABLE_NAME} ADD COLUMN $column $definition"
                        )
                    }
                }
            }
        }
    }

    companion object{
        private const val  DATABASE_NAME = "pokedex.db"
        private const val DATABASE_VERSION = 2
    }
}