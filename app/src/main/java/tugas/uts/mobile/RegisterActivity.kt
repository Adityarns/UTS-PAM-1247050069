package tugas.uts.mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { _, insets -> insets }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cardLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top + 16, v.paddingRight, systemBars.bottom + 16)
            insets
        }

        findViewById<TextView>(R.id.textLogin).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.registerButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.textName).text.toString().trim()
            val email = findViewById<EditText>(R.id.textEmail).text.toString().trim()
            val pass = findViewById<EditText>(R.id.textPassword).text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newUser = User(name = name, email = email, pass = pass)
            val success = UserRepository.register(newUser)

            if (success) {
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("USER_NAME", name)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email sudah terdaftar!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
