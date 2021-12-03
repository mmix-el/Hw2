package xyz.mmixel.hw2.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.mmixel.hw2.R

class TwoActivitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_activities)
        supportActionBar?.title = this.javaClass.simpleName
    }
}