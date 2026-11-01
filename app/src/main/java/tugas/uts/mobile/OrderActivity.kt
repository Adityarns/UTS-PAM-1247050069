package tugas.uts.mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.orderMain)) { _, insets -> insets }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cardLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(v.paddingLeft, systemBars.top + 16, v.paddingRight, systemBars.bottom + 16)
            insets
        }

        // Back button action
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        val containerOrderItems = findViewById<LinearLayout>(R.id.containerOrderItems)
        val cartItems = OrderManager.getItems()

        for (item in cartItems) {
            val tv = TextView(this).apply {
                text = "• ${item.foodItem.name} (x${item.quantity}) - ${item.foodItem.price}"
                setTextColor(resources.getColor(R.color.text_primary, theme))
                textSize = 14f
                setPadding(0, 4, 0, 4)
            }
            containerOrderItems.addView(tv)
        }

        val inputAddress = findViewById<EditText>(R.id.inputAddress)
        val inputLandmark = findViewById<EditText>(R.id.inputLandmark)
        val btnSubmitOrder = findViewById<Button>(R.id.btnSubmitOrder)
        val currentUserName = intent.getStringExtra("USER_NAME") ?: "User"

        btnSubmitOrder.setOnClickListener {
            val address = inputAddress.text.toString().trim()
            val landmark = inputLandmark.text.toString().trim()

            if (address.isEmpty() || landmark.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi alamat dan patokan!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            OrderManager.clear()
            val intent = Intent(this, OrderSuccessActivity::class.java).apply {
                putExtra("USER_NAME", currentUserName)
            }
            startActivity(intent)
            finish()
        }
    }
}
