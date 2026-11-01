package tugas.uts.mobile

object OrderManager {
    private val cart = mutableMapOf<String, CartItem>()

    fun addItem(item: FoodItem, qty: Int) {
        if (cart.containsKey(item.name)) {
            cart[item.name]?.quantity = cart[item.name]!!.quantity + qty
        } else {
            cart[item.name] = CartItem(item, qty)
        }
    }

    fun getItems(): List<CartItem> = cart.values.toList()

    fun clear() {
        cart.clear()
    }
}
