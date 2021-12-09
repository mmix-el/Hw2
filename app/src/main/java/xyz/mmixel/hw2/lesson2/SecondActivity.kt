package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.ActivitySecondBinding

private const val LOG_TAG: String = "SecondActivity"
const val EXTRA_REPLY = "com.example.android.twoActivities.EXTRA_REPLY"

/**
 * 2.1 Activities and intents
 */
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.saHandler = this

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        with(binding) {
            receivedText.text = message
            replyButton.setOnClickListener {
                val replyIntent = Intent()
                replyIntent.putExtra(EXTRA_REPLY, replyText.text)
                setResult(RESULT_OK, replyIntent)
                Log.d(LOG_TAG, "End SecondActivity")
                finish()
            }
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
