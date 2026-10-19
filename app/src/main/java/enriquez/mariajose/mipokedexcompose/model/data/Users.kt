package enriquez.mariajose.mipokedexcompose.model.data

import enriquez.mariajose.mipokedexcompose.model.domain.User

val validUsers = listOf<User>(
    User("maria.enriquez@gmail.com", "123456", "Maria Jose"),
    User("pepe@gmail.com", "56789", "Pepe"),
    User("lillia@gmail.com", "5468103", "Lillia")
)

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