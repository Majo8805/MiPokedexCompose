package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import enriquez.mariajose.mipokedexcompose.model.data.Users

class UserViewModel(users: Users): ViewModel() {
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")

    val users = users

    fun login(user: String, password: String) {
        val user = users.loginService(user, password)
        if (user == null){
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos."
        } else {
            loginError = false
            errorDescription = ""
            users.saveUser(user.email, user.name)
        }
    }

    fun isLoggedIn(): Boolean {
        return users.isLoggedIn()
    }
}