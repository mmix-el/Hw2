package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import xyz.mmixel.hw2.R

private const val TAG = "HelloWorldActivity"

/**
 * 1.1: Android Studio and Hello World
 */
class HelloWorldActivity : AppCompatActivity() {
    private val logMessage = "Hello Log!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)

        // Trigger and log an exception
        try {
            // code that may throw an exception
            throw Exception("I'm an Exception")
        } catch (e: Exception) {
            // code for handling the exception
            Log.e(TAG, "Exception has logged: ${e.message}")
        }

        // Log statements for various awareness levels
        Log.v(TAG, "Verbose: $logMessage")
        Log.d(TAG, "Debug: $logMessage")
        Log.i(TAG, "Info: $logMessage")
        Log.w(TAG, "Warning: $logMessage")
        Log.e(TAG, "Error: $logMessage")
        Log.println(Log.ASSERT, TAG, "Assert: $logMessage")
    }
}