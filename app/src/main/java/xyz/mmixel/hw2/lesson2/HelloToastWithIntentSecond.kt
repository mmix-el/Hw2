package xyz.mmixel.hw2.lesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivityHellowToastWithIntentSecondBinding

/**
 * 2.1 Activities and intents (Hello toast with intent)
 */
class HelloToastWithIntentSecond : AppCompatActivity() {
    private lateinit var binding: ActivityHellowToastWithIntentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_hellow_toast_with_intent_second
        )
        binding.htsHandler = this
        val count = intent.getIntExtra(EXTRA_HELLO_COUNT, 0)
        binding.countValue.text = count.toString()
    }
}
