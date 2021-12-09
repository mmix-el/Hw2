package xyz.mmixel.hw2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

class OneTwoThreeSecond : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_two_three_second)

        textView = findViewById(R.id.display_text)
        textView.text = intent.getStringExtra(EXTRA_TEXT)
    }
}