package xyz.mmixel.hw2.lesson2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity




private val LOG_TAG: String = TwoActivities::class.java.simpleName
const val EXTRA_MESSAGE = "xyz.mmixel.hw2.lesson2.EXTRA_MESSAGE"

class TwoActivities : AppCompatActivity() {
    private lateinit var messageEditText: EditText
    private lateinit var replyHeadTextView: TextView
    private lateinit var replyTextView: TextView

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val reply: String? = result.data?.getStringExtra(EXTRA_REPLY)
            replyHeadTextView.visibility = View.VISIBLE
            replyTextView.text = reply
            replyTextView.visibility = View.VISIBLE
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(xyz.mmixel.hw2.R.layout.activity_2_activities)

        messageEditText = findViewById(xyz.mmixel.hw2.R.id.editText_main)
        replyHeadTextView = findViewById(xyz.mmixel.hw2.R.id.text_header_reply)
        replyTextView = findViewById(xyz.mmixel.hw2.R.id.text_message_reply)

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                replyHeadTextView.visibility = View.VISIBLE
                replyTextView.text = savedInstanceState
                    .getString("reply_text")
                replyTextView.visibility = View.VISIBLE
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (replyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text",
                replyTextView.text.toString())
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

    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, messageEditText.text)
        startForResult.launch(intent)
    }

}