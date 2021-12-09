package xyz.mmixel.hw2.lesson2.activitiesandintents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity




private val TAG: String = TwoActivities::class.java.simpleName
const val EXTRA_MESSAGE = "xyz.mmixel.hw2.lesson2.activitiesandintents.EXTRA_MESSAGE"

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

        messageEditText = findViewById(xyz.mmixel.hw2.R.id.editText_main);
        replyHeadTextView = findViewById(xyz.mmixel.hw2.R.id.text_header_reply);
        replyTextView = findViewById(xyz.mmixel.hw2.R.id.text_message_reply);
    }

    fun launchSecondActivity(view: View?) {
        Log.d(TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, messageEditText.text)
        startForResult.launch(Intent(this, SecondActivity::class.java))
    }

}