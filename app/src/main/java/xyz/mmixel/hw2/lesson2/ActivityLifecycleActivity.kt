package xyz.mmixel.hw2.lesson2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

class ActivityLifecycleActivity : AppCompatActivity() {
    var count = 0
    lateinit var showCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_activity)
        supportActionBar?.title = "ActivityLifecycleActivity"
        showCount = findViewById(R.id.textView3)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("key")
            showCount.text = count.toString()
        }
    }

    fun countHandler(v: View) {
        showCount.text = "${++count}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("key")
        showCount.text = count.toString()
    }
}