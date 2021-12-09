package xyz.mmixel.hw2.lesson2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    private lateinit var shoppingItemsViews: List<TextView>

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val index: Int = result.data?.getIntExtra(EXTRA_INDEX, 0)!!
            val itemName: String = result.data?.getStringExtra(EXTRA_PICKED_ITEM)!!
            with(shoppingItemsViews[index]){
                text = itemName
                visibility = View.VISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        binding.cartHandler = this

        shoppingItemsViews = with(binding) {
            listOf(cartItem0, cartItem1, cartItem2, cartItem3, cartItem4, cartItem5,
                cartItem6, cartItem7, cartItem8, cartItem9)
        }
    }

    fun addItem(v: View) {
        val intent = Intent(this, ShopActivity::class.java)
        startForResult.launch(intent)
    }
}