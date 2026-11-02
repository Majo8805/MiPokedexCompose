package enriquez.mariajose.mipokedexcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import enriquez.mariajose.mipokedexcompose.model.data.Users
import enriquez.mariajose.mipokedexcompose.model.domain.User

class UserViewModel(users: Users): ViewModel() {

    var currentUser by mutableStateOf<User?>(null)
    init {
        currentUser = users.getCurrentUser()
    }
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")

    val users = users

    fun login(user: String, password: String) {
        val loggedUser = users.loginService(user, password)
        if (loggedUser == null){
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos."
            currentUser = null
        } else {
            loginError = false
            errorDescription = ""
            currentUser = loggedUser
            users.saveUser(loggedUser.email, loggedUser.name)
        }
    }

    fun logout() {
        users.logout()
        currentUser = null
        loginError = false
        errorDescription = ""
    }

    fun isLoggedIn(): Boolean {
        return currentUser != null || users.isLoggedIn()
    }
}