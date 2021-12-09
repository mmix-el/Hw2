package xyz.mmixel.hw2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.databinding.ActivityNavBinding
import xyz.mmixel.hw2.lesson1.*
import xyz.mmixel.hw2.lesson2.ActivityLifecycleActivity
import xyz.mmixel.hw2.lesson2.ImplicitIntentsActivity
import xyz.mmixel.hw2.lesson2.activitiesandintents.HelloToastWithIntent

private const val TAG = "NavActivity"

class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav)
        supportActionBar?.title = "NavActivity"
        binding.navHandler = this
    }

    fun navigate(resId: Int) {
        val dst = when (resId) {
            R.id.helloWorld -> HelloWorldActivity::class.java
            R.id.helloToastPtA -> HelloToastPtA::class.java
            R.id.helloConstraint -> HelloConstraint::class.java
            R.id.scrollingText -> ScrollingTextActivity::class.java
            R.id.learnToHelpYourself -> LearnToHelpYourselfActivity::class.java
            R.id.twoActivities -> HelloToastWithIntent::class.java
            R.id.activityLifecycle -> ActivityLifecycleActivity::class.java
            R.id.implicitIntents -> ImplicitIntentsActivity::class.java
            else -> {
                Log.wtf(TAG, "Undefined behavior: resId=$resId!"); null
            }
        } ?: return
        startActivity(Intent(this, dst))
    }
}