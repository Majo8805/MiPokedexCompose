package enriquez.mariajose.mipokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import enriquez.mariajose.mipokedexcompose.components.MenuPokedex
import enriquez.mariajose.mipokedexcompose.data.pokemonList
import enriquez.mariajose.mipokedexcompose.ui.theme.MiPokedexComposeTheme

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedexComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedex(
                        pokemonList = pokemonList,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}
