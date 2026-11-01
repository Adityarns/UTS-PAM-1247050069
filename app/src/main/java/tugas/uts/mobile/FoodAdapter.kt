package tugas.uts.mobile

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewFood)
        val textName: TextView = itemView.findViewById(R.id.textFoodName)
        val textDesc: TextView = itemView.findViewById(R.id.textFoodDesc)
        val textPrice: TextView = itemView.findViewById(R.id.textFoodPrice)
        val btnAddOrder: Button = itemView.findViewById(R.id.btnAddOrder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foodList[position]
        holder.imageView.setImageResource(item.image)
        holder.textName.text = item.name
        holder.textDesc.text = item.description
        holder.textPrice.text = item.price

        holder.btnAddOrder.setOnClickListener { v ->
            val context = v.context
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_order, null)

            val foodNameText = dialogView.findViewById<TextView>(R.id.dialogFoodName)
            val inputQty = dialogView.findViewById<EditText>(R.id.dialogInputQty)
            val btnCancel = dialogView.findViewById<TextView>(R.id.dialogBtnCancel)
            val btnAdd = dialogView.findViewById<TextView>(R.id.dialogBtnAdd)

            foodNameText.text = item.name
            inputQty.setText("1")

            val dialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .create()

            // Make window background transparent so rounded glass card shape is visible
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            btnCancel.setOnClickListener {
                dialog.dismiss()
            }

            btnAdd.setOnClickListener {
                val qtyStr = inputQty.text.toString().trim()
                val qty = qtyStr.toIntOrNull() ?: 1
                OrderManager.addItem(item, qty)
                Toast.makeText(
                    context,
                    "Berhasil menambahkan $qty ${item.name} ke keranjang",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    override fun getItemCount(): Int = foodList.size
}
