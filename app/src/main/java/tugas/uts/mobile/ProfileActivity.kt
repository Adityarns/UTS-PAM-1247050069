package tugas.uts.mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profileMain)) { _, insets -> insets }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cardLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top + 16, v.paddingRight, systemBars.bottom + 16)
            insets
        }

        val inputName = findViewById<EditText>(R.id.inputProfileName)
        val inputEmail = findViewById<EditText>(R.id.inputProfileEmail)
        val inputPass = findViewById<EditText>(R.id.inputProfilePassword)
        val btnSave = findViewById<Button>(R.id.btnSaveProfile)

        // Get passed username if available
        val currentName = intent.getStringExtra("USER_NAME") ?: "Aditya Rahman"
        inputName.setText(currentName)
        inputEmail.setText("user@mail.com")

        btnSave.setOnClickListener {
            val name = inputName.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val pass = inputPass.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Nama dan Email tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Profil berhasil diperbarui!", Toast.LENGTH_LONG).show()
        }

        // Bottom Navigation functionality
        findViewById<LinearLayout>(R.id.navHome).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("USER_NAME", inputName.text.toString())
            }
            startActivity(intent)
            finish()
        }

        findViewById<LinearLayout>(R.id.navProfile).setOnClickListener {
            // Already on Profile
        }
    }
}
