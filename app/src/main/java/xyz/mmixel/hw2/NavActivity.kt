package xyz.mmixel.hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import timber.log.Timber
import xyz.mmixel.hw2.databinding.ActivityNavBinding
import xyz.mmixel.hw2.lesson1.*
import xyz.mmixel.hw2.lesson2.ActivityLifecycleActivity
import xyz.mmixel.hw2.lesson2.ImplicitIntentsActivity
import xyz.mmixel.hw2.lesson2.TwoActivitiesActivity

class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav)
        supportActionBar?.title = this.javaClass.simpleName
        setListeners()
    }

    private fun setListeners() {
        val buttons: List<Button> = with(binding) {
            listOf(
                helloWorld, helloToastPtA, helloToastPtB, scrollingText, learnToHelpYourself,
                twoActivities, activityLifecycle, implicitIntents
            )
        }
        for (button in buttons) {
            button.setOnClickListener { navigate(button.id) }
        }
    }

    private fun navigate(resId: Int) {
        val dst = when (resId) {
            R.id.helloWorld -> HelloWorldActivity::class.java
            R.id.helloToastPtA -> HelloToastPtA::class.java
            R.id.helloToastPtB -> HelloToastPtB::class.java
            R.id.scrollingText -> ScrollingTextActivity::class.java
            R.id.learnToHelpYourself -> LearnToHelpYourselfActivity::class.java
            R.id.twoActivities -> TwoActivitiesActivity::class.java
            R.id.activityLifecycle -> ActivityLifecycleActivity::class.java
            R.id.implicitIntents -> ImplicitIntentsActivity::class.java
            else -> {
                Timber.wtf("Undefined behavior: resId=$resId!"); null
            }
        } ?: return

        startActivity(Intent(this, dst))
    }
}