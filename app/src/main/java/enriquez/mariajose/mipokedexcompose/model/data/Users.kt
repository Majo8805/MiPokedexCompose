package enriquez.mariajose.mipokedexcompose.model.data

import android.content.Context
import enriquez.mariajose.mipokedexcompose.model.domain.User
import enriquez.mariajose.mipokedexcompose.model.preferences.ARCHIVO
import enriquez.mariajose.mipokedexcompose.model.preferences.USER
import enriquez.mariajose.mipokedexcompose.model.preferences.USERNAME
import kotlin.apply

class Users(context: Context) {
    val validUsers = listOf<User>(
        User("maria.enriquez@gmail.com", "123456", "Maria Jose"),
        User("pepe@gmail.com", "56789", "Pepe"),
        User("lillia@gmail.com", "5468103", "Lillia")
    )

    val shared = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE)

    fun getUserByEmail(mail: String): User?{
        val users = validUsers.filter {
            it.email.equals(mail, true)
        }
        return if (users.isEmpty()) null else users.first()
    }

    fun loginService(user: String, password: String): User?{
        val user = getUserByEmail(user)
        user?.let {
            if (user.password.equals(password)){
                return user
            }
        }
        return null
    }

    fun saveUser(user: String, name: String){
        val editor = shared.edit()
        editor.putString(USER, user)
        editor.putString(USERNAME, name)
        editor.apply()
    }

    fun logout() {
        val editor = shared.edit()
        editor.putString(USER, null)
        editor.putString(USERNAME, null)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        val user = shared.getString(USER, null)
        val username = shared.getString(USERNAME, null)

        if (user != null && username != null) {
            return true
        }
        return false
    }
}
