package enriquez.mariajose.mipokedexcompose.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import enriquez.mariajose.mipokedexcompose.R
import enriquez.mariajose.mipokedexcompose.model.data.absol
import enriquez.mariajose.mipokedexcompose.model.domain.Pokemon
import enriquez.mariajose.mipokedexcompose.navigation.PokemonDetail
import enriquez.mariajose.mipokedexcompose.ui.theme.Grey
import enriquez.mariajose.mipokedexcompose.ui.theme.LightBlue
import enriquez.mariajose.mipokedexcompose.ui.theme.White
import enriquez.mariajose.mipokedexcompose.utilities.getColorByType
import enriquez.mariajose.mipokedexcompose.view.components.CuadroBlanco

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Pokemon, colors: Pair<Color, Color>) {
    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.first)
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 25.dp)
        ) {
            Text(
                text = pokemon.name,
                color = colors.second,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "N° " + pokemon.number,
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                color = Grey,
                fontSize = 20.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.estrella),
            contentDescription = "star",
            modifier = Modifier
                .padding(10.dp)
                .size(45.dp)
                .align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_pokeball),
            contentDescription = "pokeball",
            modifier = Modifier
                .offset(x = 200.dp, y = 65.dp)
                .size(230.dp)
        )
        CuadroBlanco(pokemon)
        Image(
            painterResource(pokemon.image), contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 25.dp)
                .size(260.dp),
            Alignment.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {
    PokemonDetailScreen(PaddingValues(10.dp, 15.dp), absol, getColorByType(absol.type))
}