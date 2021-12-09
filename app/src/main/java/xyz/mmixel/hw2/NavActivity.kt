package xyz.mmixel.hw2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.mmixel.hw2.databinding.ActivityNavBinding
import xyz.mmixel.hw2.lesson1.HelloConstraint
import xyz.mmixel.hw2.lesson1.HelloToastPtA
import xyz.mmixel.hw2.lesson1.HelloWorldActivity
import xyz.mmixel.hw2.lesson1.ScrollingTextActivity
import xyz.mmixel.hw2.lesson2.*

private const val TAG = "NavActivity"

class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav)
        binding.navHandler = this
    }

    fun navigate(resId: Int) {
        val dst = when (resId) {
            R.id.helloWorld -> HelloWorldActivity::class.java
            R.id.helloToastPtA -> HelloToastPtA::class.java
            R.id.helloConstraint -> HelloConstraint::class.java
            R.id.scrollingText -> ScrollingTextActivity::class.java
            R.id.twoActivities -> TwoActivities::class.java
            R.id.helloToastWithIntent -> HelloToastWithIntent::class.java
            R.id.activityLifecycle -> ActivityLifecycleActivity::class.java
            R.id.implicitIntents -> ImplicitIntentsActivity::class.java
            R.id.cartActivity -> CartActivity::class.java
            R.id.oneTwoThree -> OneTwoThreeFirst::class.java
            else -> throw IndexOutOfBoundsException("Bad Index: resId = $resId!")
        }
        startActivity(Intent(this, dst))
    }
}