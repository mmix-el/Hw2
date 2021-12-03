package xyz.mmixel.hw2.lesson1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import xyz.mmixel.hw2.R

private const val TAG = "HelloWorldActivity"

/**
 *  1.1: Android Studio and Hello World
 */
class HelloWorldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        supportActionBar?.title = this.javaClass.simpleName

        Timber.d("onCreate called!")
        Timber.v("Verbose")
        Timber.d("Debug")
        Timber.i("Info")
        Timber.w("Warning")
        Timber.e("Error")
        Timber.wtf("WTF/Assert")
        Log.println(Log.ASSERT, TAG, "Assert")
    }
}