package enriquez.mariajose.mipokedexcompose.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import enriquez.mariajose.mipokedexcompose.model.data.Users
import enriquez.mariajose.mipokedexcompose.model.data.getPokemonByNumber
import enriquez.mariajose.mipokedexcompose.utilities.getColorByType
import enriquez.mariajose.mipokedexcompose.view.screens.LoginScreen
import enriquez.mariajose.mipokedexcompose.view.screens.MenuPokedexScreen
import enriquez.mariajose.mipokedexcompose.view.screens.PokemonDetailScreen
import enriquez.mariajose.mipokedexcompose.view.screens.PokemonHuntScreen
import enriquez.mariajose.mipokedexcompose.viewModel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, userViewModel: UserViewModel) {
    val navController = rememberNavController()
    val onNavigateToDetail ={id: Int -> navController.navigate(route = PokemonDetail(id))}
    val onNavigateToMenu = {navController.navigate(PokemonList)}


    NavHost(navController, startDestination = Login){
        composable<Login> {
            LoginScreen(innerPadding, onNavigateToMenu, userViewModel)
        }

        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateToDetail = onNavigateToDetail,
                onNavigateToHunt =
                    {navController.navigate(route = PokemonHunt)
                })
        }
        composable<PokemonDetail>() { backStackEntry ->
            val pokemonDetail = backStackEntry.toRoute<PokemonDetail>()
            val idPokemon = pokemonDetail.pokemon
            val pokemon = getPokemonByNumber(idPokemon)
            val pokemonColors = getColorByType(pokemon.type)
            PokemonDetailScreen(innerPadding, getPokemonByNumber(idPokemon), pokemonColors)
        }
        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding, onNavigateToDetail = onNavigateToDetail)
        }
    }
}