package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

/**
 *  1.1: Android Studio and Hello World
 */
class ScrollingTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_text)
        supportActionBar?.title = "ScrollingTextActivity"
    }
}