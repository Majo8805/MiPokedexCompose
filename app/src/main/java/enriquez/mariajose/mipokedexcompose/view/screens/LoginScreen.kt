package enriquez.mariajose.mipokedexcompose.view.screens

import android.view.Menu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import enriquez.mariajose.mipokedexcompose.viewModel.UserViewModel

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    onNavigateToMenu: () -> Unit,
    viewModel: UserViewModel = viewModel()
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf(value = "") }

    if (viewModel.isLoggedIn()) {
        onNavigateToMenu
    } else {
        Column(Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            TextField(value = user,
                label = {Text("Correo Electronico")},
                onValueChange = {it -> user = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

            TextField(value = password,
                label = {Text("Contraseña")},
                onValueChange = {it -> password = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

            Button(onClick = {
                viewModel.login(user, password)
                if (!viewModel.loginError) {
                    onNavigateToMenu
                }
            }) {
                Text("Iniciar Sesión")
            }

            Spacer(Modifier.size(40.dp))

            if(viewModel.loginError) {
                Text(viewModel.errorDescription, color = Color.Red, fontStyle = FontStyle.Italic)
            }
        }
    }


}