package xyz.mmixel.hw2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

class HelloToastWithIntentSecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hellow_toast_with_intent_second)
        val count = intent.getIntExtra("HELLO_COUNT", 0)
        findViewById<TextView>(R.id.count_value).text = count.toString()
    }
}
