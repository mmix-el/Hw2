package xyz.mmixel.hw2.lesson2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

const val UNIQUE_KEY = "xyz.mmixel.hw2.lesson2.UNIQUE_KEY"

/**
 * 2.2: Activity lifecycle and state
 */
class ActivityLifecycleActivity : AppCompatActivity() {
    private var count = 0
    lateinit var showCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_activity)
        showCount = findViewById(R.id.counterDisplay)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(UNIQUE_KEY)
            showCount.text = count.toString()
        }
    }

    fun countHandler(v: View) {
        showCount.text = "${++count}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(UNIQUE_KEY, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(UNIQUE_KEY)
        showCount.text = count.toString()
    }
}