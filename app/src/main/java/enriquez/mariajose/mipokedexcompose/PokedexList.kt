package enriquez.mariajose.mipokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import enriquez.mariajose.mipokedexcompose.components.MenuPokedex
import enriquez.mariajose.mipokedexcompose.data.pokemonList
import enriquez.mariajose.mipokedexcompose.screens.MenuPokedexScreen
import enriquez.mariajose.mipokedexcompose.ui.theme.MiPokedexComposeTheme

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedexComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedexScreen(
                        pokemonList = pokemonList,
                        favoriteList = pokemonList.filter { it.favorite },
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}
