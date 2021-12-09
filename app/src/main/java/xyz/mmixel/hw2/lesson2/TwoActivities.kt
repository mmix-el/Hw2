package xyz.mmixel.hw2.lesson2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.R
import xyz.mmixel.hw2.databinding.Activity2ActivitiesBinding

private const val LOG_TAG: String = "TwoActivities"
const val EXTRA_MESSAGE = "xyz.mmixel.hw2.lesson2.EXTRA_MESSAGE"

/**
 * 2.1 Activities and intents
 */
class TwoActivities : AppCompatActivity() {
    private lateinit var binding: Activity2ActivitiesBinding

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val reply: String? = result.data?.getStringExtra(EXTRA_REPLY)
            with(binding) {
                replyHeadTextView.visibility = View.VISIBLE
                replyTextView.text = reply
                replyTextView.visibility = View.VISIBLE
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_2_activities)
        binding.taHandler = this

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                with(binding) {
                    replyHeadTextView.visibility = View.VISIBLE
                    replyTextView.text = savedInstanceState.getString("reply_text")
                    replyTextView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (binding.replyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.replyTextView.text.toString())
        }
    }

    fun launchSecondActivity(v: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, binding.replyTextView.text)
        startForResult.launch(intent)
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