package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityShopBinding

const val EXTRA_PICKED_ITEM = "xyz.mmixel.hw2.lesson2.extra.PICKED_ITEM"
const val EXTRA_INDEX = "xyz.mmixel.hw2.lesson2.extra.INDEX"


class ShopActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop)
        binding.shopHandler = this
    }

    fun pickItem(resId: Int) {
        val (item, index) = when(resId) {
            R.id.applesButton -> "apples" to 0
            R.id.breadButton -> "bread" to 1
            R.id.cheeseButton -> "cheese" to 2
            R.id.eggsButton -> "eggs" to 3
            R.id.milkButton -> "milk" to 4
            R.id.oliveOilButton -> "olive oil" to 5
            R.id.redBeansButton -> "red beans" to 6
            R.id.pastaButton -> "pasta" to 7
            R.id.riceButton -> "rice" to 8
            R.id.turkeyButton -> "turkey" to 9
            else -> Pair("", -1)
        }
        val intent = Intent()
        intent.putExtra(EXTRA_INDEX, index)
        intent.putExtra(EXTRA_PICKED_ITEM, item)
        setResult(RESULT_OK, intent)
        finish()
    }

    fun openStoreLocation(v: View) {
        val loc = binding.locationEdittext.text.toString()
        val addressUri: Uri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }
}