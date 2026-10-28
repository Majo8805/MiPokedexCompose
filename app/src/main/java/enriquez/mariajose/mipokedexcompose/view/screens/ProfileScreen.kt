package enriquez.mariajose.mipokedexcompose.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import enriquez.mariajose.mipokedexcompose.ui.theme.Pink40
import enriquez.mariajose.mipokedexcompose.ui.theme.Typography
import enriquez.mariajose.mipokedexcompose.viewModel.UserViewModel

@Composable
fun ProfileScreen(innerPadding: PaddingValues, userViewModel: UserViewModel = viewModel()) {
    val nombre = "Majo"
    val mail = "correo@mail.com"

    Column(Modifier.fillMaxSize().padding(innerPadding).padding(15.dp)) {
        Text (if (userViewModel.currentUser != null) "${userViewModel.currentUser!! .name}" else "Nombre usuario",
                style = Typography.displayLarge, color = Pink40
        )
        Text(if (userViewModel.currentUser != null) "${userViewModel.currentUser!! .email}" else "usuario@mail.com")
        Spacer(Modifier.size(50.dp))
        Text()
    }
}

@Composable
@Preview(backgroundColor = true)
fun ProfileScreenPreview() {
    ProfileScreen()
}