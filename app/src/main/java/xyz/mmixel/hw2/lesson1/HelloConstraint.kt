package xyz.mmixel.hw2.lesson1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityHelloConstraintBinding

fun Int.isEven() = (this and 1) == 0
private const val TAG = "HelloConstraint"

/**
 * 1.2 Part B: The layout editor
 */
class HelloConstraint : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityHelloConstraintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "HelloConstraint"
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_hello_constraint)
        binding.hcHandler = this
        buttonColorHandler()
    }

    fun showToast(view: View?) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun zeroIn(view: View?) {
        count = 0
        binding.showCount.text = count.toString()
        buttonColorHandler()
    }

    fun countUp(view: View?) {
        binding.showCount.text = "${++count}"
        buttonColorHandler()
    }

    private fun buttonColorHandler() {
        with(binding) {
            buttonToast.setBackgroundColor(Color.BLUE)
            buttonZero.setBackgroundColor(if (count == 0) Color.GRAY else Color.MAGENTA)
            buttonCount.setBackgroundColor(if (count.isEven()) Color.BLUE else Color.BLACK)
        }
    }
}