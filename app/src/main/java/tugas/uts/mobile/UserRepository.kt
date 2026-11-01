package tugas.uts.mobile

data class User(
    val name: String,
    val email: String,
    val pass: String
)

object UserRepository {
    // Static in-memory database of registered users
    private val users = mutableListOf<User>(
        User(name = "Aditya Rahman", email = "aditya@mail.com", pass = "123456")
    )

    fun register(user: User): Boolean {
        // Check if email already exists
        if (users.any { it.email.equals(user.email, ignoreCase = true) }) {
            return false
        }
        users.add(user)
        return true
    }

    fun login(email: String, pass: String): User? {
        return users.find { it.email.equals(email, ignoreCase = true) && it.pass == pass }
    }
}
