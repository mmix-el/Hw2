package xyz.mmixel.hw2.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.mmixel.hw2.R

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
        supportActionBar?.title = this.javaClass.simpleName
    }
}