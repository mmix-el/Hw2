package xyz.mmixel.hw2.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import xyz.mmixel.hw2.R

class ScrollingTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_text)
        supportActionBar?.title = this.javaClass.simpleName
        Timber.d("onCreate called!")
    }
}