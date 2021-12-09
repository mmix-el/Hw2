package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

/**
 * 1.3: Text and scrolling views
 */
class ScrollingTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_text2)
        supportActionBar?.title = "ScrollingTextActivity"
    }
}