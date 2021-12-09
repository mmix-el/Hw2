package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

const val EXTRA_TEXT = "EXTRA_TEXT"

class OneTwoThreeFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_two_three_first)

        findViewById<Button>(R.id.pickText1).apply {
            setOnClickListener {
                buttonsHandler(it.id)

            }
        }
        findViewById<Button>(R.id.pickText2).apply {
            setOnClickListener {
                buttonsHandler(it.id)

            }
        }
        findViewById<Button>(R.id.pickText3).apply {
            setOnClickListener {
                buttonsHandler(it.id)
            }
        }
    }

    private fun buttonsHandler(resId: Int) {
        val textPassageId = when (resId) {
            R.id.pickText1 -> R.string.text_passage1
            R.id.pickText2 -> R.string.text_passage2
            R.id.pickText3 -> R.string.text_passage3
            else -> -1
        }
        val intent = Intent(this, OneTwoThreeSecond::class.java)
        intent.putExtra(EXTRA_TEXT, getString(textPassageId))
        startActivity(intent)
    }
}