package enriquez.mariajose.mipokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.ui.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import enriquez.mariajose.mipokedexcompose.ui.theme.Blue
import enriquez.mariajose.mipokedexcompose.ui.theme.Grey
import enriquez.mariajose.mipokedexcompose.ui.theme.LightBlue
import enriquez.mariajose.mipokedexcompose.ui.theme.MiPokedexComposeTheme
import enriquez.mariajose.mipokedexcompose.ui.theme.Pink
import enriquez.mariajose.mipokedexcompose.ui.theme.Red
import enriquez.mariajose.mipokedexcompose.ui.theme.White
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaCompletaPokedex()
        }
    }
}

@Composable
fun PantallaCompletaPokedex() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBlue),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 25.dp, top = 25.dp)
        ) {
            Text(
                text = "Primarina",
                modifier = Modifier
                    .padding(0.dp, 8.dp),
                color = White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
                )
            Text(
                text = "N° 0730",
                modifier = Modifier
                    .padding(60.dp, 0.dp),
                color = Grey,
                fontSize = 20.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.estrella),
            contentDescription = "star",
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_pokeball),
            contentDescription = "pokeball",
            modifier = Modifier
                .offset(x = 200.dp, y = 65.dp)
                .size(230.dp)
        )
        CuadroBlanco()
        Image(
            painter = painterResource(id = R.drawable.primarina),
            contentDescription = "primarina",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 35.dp)
                .size(300.dp)
        )
    }
}

@Composable
fun CuadroBlanco() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = Modifier
            .padding(0.dp,220.dp, 0.dp, 30.dp)
            .fillMaxWidth()
            .height(600.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 85.dp),
            Arrangement.Center
        ) {
            TipoAgua()
            TipoHada()
        }
        Column() {
            Row(
                modifier = Modifier
                    .padding(start = 30.dp)
            ) {
                Text(
                    text = "Altura",
                    modifier = Modifier
                        .padding(end = 10.dp),
                    color = Red,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "1,8 m",
                    modifier = Modifier
                        .padding(end = 40.dp),
                    fontSize = 25.sp
                )
                Column() {
                    Text(
                        text = "Habilidad",
                        color = Red,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Torrente",
                        fontSize = 25.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 30.dp)
            ) {
                Text(
                    text = "Peso",
                    modifier = Modifier
                        .padding(end = 10.dp),
                    color = Red,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "44,0 kg",
                    fontSize = 25.sp
                )
            }
        }
        Text(
            text = "Primarina considera los combates como un escenario ideal donde abatir a su presa con un canto y baile que derrochan elegancia.",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(20.dp, 30.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PokemonAnterior()
            PokemonSiguiente()
        }
    }
}

@Composable
fun TipoAgua() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Blue
        ),
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(text = "Agua",
            modifier = Modifier
                .padding(45.dp, 5.dp),
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun TipoHada() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Pink
        ),
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(text = "Hada",
            modifier = Modifier
                .padding(45.dp, 5.dp),
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun PokemonAnterior() {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.brionne),
                contentDescription = "brionne",
                modifier = Modifier
                    .padding(start = 18.dp)
                    .size(150.dp)

            )
            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                FlechaAnterior()
                Text(
                    text = "Brionne N° 0729",
                    modifier = Modifier
                        .padding(start = 10.dp),
                )
            }
        }
}

@Composable
fun PokemonSiguiente() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.pikipek),
            contentDescription = "pikipek",
            modifier = Modifier
                .padding(start = 18.dp)
                .size(150.dp)

        )
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Pikipek N° 0731",
                modifier = Modifier
                    .padding(end = 10.dp),
            )
            FlechaSiguiente()
        }
    }
}

@Composable
fun FlechaAnterior() {
    Image(
        painter = painterResource(id = R.drawable.flecha_atras),
        contentDescription = "flecha para atras",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(30.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Grey)
    )
}

@Composable
fun FlechaSiguiente() {
    Image(
        painter = painterResource(id = R.drawable.flecha_delante),
        contentDescription = "flecha para adelante",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(30.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Grey)
    )
}

@Preview(showBackground = true)
@Composable
fun PokedexPreview() {
    MaterialTheme {
        PantallaCompletaPokedex()
    }
}