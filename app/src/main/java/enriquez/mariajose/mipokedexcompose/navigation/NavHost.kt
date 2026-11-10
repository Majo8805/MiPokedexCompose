package enriquez.mariajose.mipokedexcompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import enriquez.mariajose.mipokedexcompose.view.screens.LoginScreen
import enriquez.mariajose.mipokedexcompose.view.screens.MenuPokedexScreen
import enriquez.mariajose.mipokedexcompose.view.screens.PokemonDetailScreen
import enriquez.mariajose.mipokedexcompose.view.screens.PokemonHuntScreen
import enriquez.mariajose.mipokedexcompose.view.screens.ProfileScreen
import enriquez.mariajose.mipokedexcompose.viewModel.PokemonDetailViewModel
import enriquez.mariajose.mipokedexcompose.viewModel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, userViewModel: UserViewModel, pokemonDetailViewModel: PokemonDetailViewModel) {
    val navController = rememberNavController()
    val onNavigateToDetail ={id: Int -> navController.navigate(route = PokemonDetail(id))}
    val onNavigateToMenu = {navController.navigate(PokemonList)}
    val onNavigateToProfile = {navController.navigate(Profile)}
    val onLogout = {
        userViewModel.logout()
        navController.navigate(Login) {
            popUpTo(0) { inclusive = true }
        }
    }

    NavHost(navController, startDestination = Login){
        composable<Login> {
            LoginScreen(innerPadding, onNavigateToMenu, userViewModel)
        }

        composable<PokemonList>{
            MenuPokedexScreen(
                innerPadding,
                onNavigateToDetail = onNavigateToDetail,
                onNavigateToHunt = { navController.navigate(route = PokemonHunt) },
                onNavigateToProfile = onNavigateToProfile,
                users = userViewModel.users,
                onLogout = onLogout
            )
        }
        composable<PokemonDetail>() { backStackEntry ->
            val pokemonDetail = backStackEntry.toRoute<PokemonDetail>()
            PokemonDetailScreen(innerPadding, pokemonDetail.pokemon, pokemonDetailViewModel)
        }
        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding, onNavigateToDetail = onNavigateToDetail)
        }

        composable<Profile> {
            ProfileScreen(innerPadding, userViewModel)
        }
    }
}