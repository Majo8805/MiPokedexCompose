package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import enriquez.mariajose.mipokedexcompose.model.data.loginService

class UserViewModel: ViewModel() {
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")

    fun login(user: String, password: String) {
        val user = loginService(user, password)
        if (user == null){
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos."
        } else {
            loginError = false
            errorDescription = ""
        }
    }
}