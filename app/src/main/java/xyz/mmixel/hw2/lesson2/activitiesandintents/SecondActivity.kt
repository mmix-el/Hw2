package xyz.mmixel.hw2.lesson2.activitiesandintents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

private val LOG_TAG: String = SecondActivity::class.java.simpleName
const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"

class SecondActivity : AppCompatActivity() {
    lateinit var reply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        findViewById<TextView>(R.id.text_message).text = message

        reply = findViewById(R.id.editText_second)
        val button: Button = findViewById(R.id.button_second)
        button.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply.text.toString())
            setResult(RESULT_OK, replyIntent)
            Log.d(LOG_TAG, "End SecondActivity");
            finish()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

}
