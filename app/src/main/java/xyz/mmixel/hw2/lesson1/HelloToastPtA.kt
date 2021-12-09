package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityHelloToastPtABinding

/**
 * 1.2 Part A: Your first interactive UI
 */
class HelloToastPtA : AppCompatActivity() {
    private var count = 0
    private lateinit var showCount: TextView
    private lateinit var binding: ActivityHelloToastPtABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hello_toast_pt_a)
        binding.htHandler = this
        showCount = binding.showCount
    }

    fun showToast(v: View?) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(v: View?) {
        showCount.text = "${++count}"
    }
}