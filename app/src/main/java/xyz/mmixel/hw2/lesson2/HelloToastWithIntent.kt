package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityHelloToastWithIntentBinding

const val EXTRA_HELLO_COUNT = "xyz.mmixel.hw2.lesson2.EXTRA_HELLO_COUNT"

/**
 * 1.2 Part A: Your first interactive UI
 */
class HelloToastWithIntent : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityHelloToastWithIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_hello_toast_with_intent
        )
        binding.htHandler = this
    }

    fun showToast(v: View?) {
        val intent = Intent(this, HelloToastWithIntentSecond::class.java)
        intent.putExtra(EXTRA_HELLO_COUNT, count)
        startActivity(intent)
    }

    fun countUp(v: View?) {
        binding.showCount.text = "${++count}"
    }
}