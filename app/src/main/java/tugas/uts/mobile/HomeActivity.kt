package tugas.uts.mobile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get username from Intent
        val userName = intent.getStringExtra("USER_NAME") ?: "User"
        findViewById<TextView>(R.id.textGreeting).text = "Halo $userName,"

        // Looping data makanan sesuai wireframe dengan gambar masing-masing
        val foodList = listOf(
            FoodItem(image = R.drawable.food1, "Matcha Espresso Latte", "• matcha, susu segar, dan shot espresso", "• Rp 28.000"),
            FoodItem(image = R.drawable.food2, "Matcha Croissant / Cruffin", "• Pastry renyah berlapis dengan isian krim matcha", "• Rp 25.000"),
            FoodItem(image = R.drawable.food3, "Matcha Basque Burnt Cheesecake", "• Cheesecake panggang dengan aroma matcha", "• Rp 30.000"),
            FoodItem(image = R.drawable.food4, "Iced Coconut Matcha", "• Kombinasi kelapa murni dan kocokan matcha", "• Rp 26.000"),
            FoodItem(image = R.drawable.food5, "Matcha Ice Cream", "• Es krim berbahan dasar matcha asli", "• Rp 15.000")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFood)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FoodAdapter(foodList)

        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener {
            val cartItems = OrderManager.getItems()
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Keranjang masih kosong! Silakan tambah pesanan.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dialogView = layoutInflater.inflate(R.layout.dialog_checkout_summary, null)
            val container = dialogView.findViewById<LinearLayout>(R.id.containerCartItems)
            val btnClose = dialogView.findViewById<TextView>(R.id.dialogBtnClose)
            val btnOrderNow = dialogView.findViewById<TextView>(R.id.dialogBtnOrderNow)

            for (cartItem in cartItems) {
                val tv = TextView(this).apply {
                    text = "${cartItem.foodItem.name} (x${cartItem.quantity})\n${cartItem.foodItem.price}"
                    setTextColor(resources.getColor(R.color.text_primary, theme))
                    textSize = 15f
                    setPadding(0, 8, 0, 12)
                }
                container.addView(tv)
            }

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            btnOrderNow.setOnClickListener {
                dialog.dismiss()
                val intent = Intent(this, OrderActivity::class.java).apply {
                    putExtra("USER_NAME", userName)
                }
                startActivity(intent)
            }

            dialog.show()
        }

        // Bottom Navigation functionality
        findViewById<LinearLayout>(R.id.navHome).setOnClickListener {
            // Already on Home
        }

        findViewById<LinearLayout>(R.id.navProfile).setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("USER_NAME", userName)
            }
            startActivity(intent)
            finish()
        }
    }
}
