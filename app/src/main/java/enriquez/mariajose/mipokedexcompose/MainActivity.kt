package enriquez.mariajose.mipokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import enriquez.mariajose.mipokedexcompose.ui.theme.Blue
import enriquez.mariajose.mipokedexcompose.ui.theme.LightBlue
import enriquez.mariajose.mipokedexcompose.ui.theme.MiPokedexComposeTheme
import enriquez.mariajose.mipokedexcompose.ui.theme.Pink
import enriquez.mariajose.mipokedexcompose.ui.theme.White

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
            .background(color = LightBlue)
    ) {
        Column() {
            Text("Primarina")
            Text("N° 0730")
        }
        CuadroBlanco()
    }
}

@Composable
fun CuadroBlanco() {
    Card(
        modifier = Modifier
            .padding(0.dp,220.dp, 0.dp, 30.dp)
            .fillMaxWidth()
            .height(600.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center
        ) {
            TipoAgua()
            TipoHada()
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

@Preview(showBackground = true)
@Composable
fun PokedexPreview() {
    MaterialTheme {
        PantallaCompletaPokedex()
    }
}