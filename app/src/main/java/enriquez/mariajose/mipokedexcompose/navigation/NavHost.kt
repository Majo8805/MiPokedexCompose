package enriquez.mariajose.mipokedexcompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import enriquez.mariajose.mipokedexcompose.model.data.getPokemonByNumber
import enriquez.mariajose.mipokedexcompose.utilities.getColorByType
import enriquez.mariajose.mipokedexcompose.view.screens.MenuPokedexScreen
import enriquez.mariajose.mipokedexcompose.view.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateToDetail =
                {id -> navController.navigate(route= PokemonDetail(id))
                })
        }
        composable<PokemonDetail>() { backStackEntry ->
            val pokemonDetail = backStackEntry.toRoute<PokemonDetail>()
            val idPokemon = pokemonDetail.pokemon
            val pokemon = getPokemonByNumber(idPokemon)
            val pokemonColors = getColorByType(pokemon.type)
            PokemonDetailScreen(innerPadding, getPokemonByNumber(idPokemon), pokemonColors)
        }
    }
}