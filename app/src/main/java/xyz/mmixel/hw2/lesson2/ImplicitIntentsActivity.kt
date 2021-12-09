package xyz.mmixel.hw2.lesson2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

/**
 * 2.3: Implicit intents
 */
class ImplicitIntentsActivity : AppCompatActivity() {
    lateinit var websiteEditText: EditText
    lateinit var locationEditText: EditText
    lateinit var shareTextEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(xyz.mmixel.hw2.R.layout.activity_implicit_intents)

        websiteEditText = findViewById(xyz.mmixel.hw2.R.id.website_edittext)
        locationEditText = findViewById(xyz.mmixel.hw2.R.id.location_edittext)
        shareTextEditText = findViewById(xyz.mmixel.hw2.R.id.share_edittext)
    }

    fun openWebsite(v: View?) {
        val url = websiteEditText.text
        val webpage: Uri = Uri.parse(url.toString())
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    fun openLocation(v: View?) {
        val loc = locationEditText.text
        val addressUri: Uri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(v: View?) {
        val txt = shareTextEditText.text
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(xyz.mmixel.hw2.R.string.share_text_with)
            .setText(txt)
            .startChooser()
    }

    fun launchCamera(v: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
}