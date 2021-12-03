package xyz.mmixel.hw2

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}