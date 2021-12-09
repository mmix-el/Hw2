package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityHelloToastWithIntentBinding

/**
 * 1.2 Part A: Your first interactive UI
 */
class HelloToastWithIntent : AppCompatActivity() {
    private var count = 0
    private lateinit var showCount: TextView
    private lateinit var binding: ActivityHelloToastWithIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "HelloToastPtA"
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_hello_toast_with_intent
        )
        binding.htHandler = this
        showCount = binding.showCount
    }

    fun showToast(view: View?) {
        val intent = Intent(this, HelloToastWithIntentSecond::class.java)
        intent.putExtra("HELLO_COUNT", count)
        startActivity(intent)
    }

    fun countUp(view: View?) {
        showCount.text = "${++count}"
    }
}