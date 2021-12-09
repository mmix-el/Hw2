package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

private const val TAG = "HelloWorldActivity"

/**
 *  1.1: Android Studio and Hello World
 */
class HelloWorldActivity : AppCompatActivity() {
    private val friendName = "Rama"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.i(TAG, "Happy Birthday $friendName!");

        try {
            throw Exception("Thrown Exception")
        } catch (e: Exception) {
            Log.e(TAG, "Exception logged: ${e.message}")
        }

        val message = "Hello Log!"
        Log.v(TAG, "Verbose: $message")
        Log.d(TAG, "Debug: $message")
        Log.i(TAG, "Info: $message")
        Log.w(TAG, "Warning: $message")
        Log.e(TAG, "Error: $message")
        Log.wtf(TAG, "WTF: $message")
        Log.println(Log.ASSERT, TAG, "Assert: $message")
    }
}