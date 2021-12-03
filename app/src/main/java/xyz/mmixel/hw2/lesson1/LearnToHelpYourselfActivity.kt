package xyz.mmixel.hw2.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.mmixel.hw2.R

class LearnToHelpYourselfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_to_help_yourself)
        supportActionBar?.title = this.javaClass.simpleName
    }
}