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
    private var mWebsiteEditText: EditText? = null
    private var mLocationEditText: EditText? = null
    private var mShareTextEditText: EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(xyz.mmixel.hw2.R.layout.activity_implicit_intents)
        supportActionBar?.title = "ImplicitIntentsActivity"
        mWebsiteEditText = findViewById(xyz.mmixel.hw2.R.id.website_edittext);
        mLocationEditText = findViewById(xyz.mmixel.hw2.R.id.location_edittext);
        mShareTextEditText = findViewById(xyz.mmixel.hw2.R.id.share_edittext);
    }

    fun openWebsite(view: View?) {
        val url = mWebsiteEditText!!.text.toString()

        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    fun openLocation(view: View?) {
        val loc = mLocationEditText!!.text.toString()

        val addressUri: Uri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View?) {
        val txt = mShareTextEditText!!.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(xyz.mmixel.hw2.R.string.share_text_with)
            .setText(txt)
            .startChooser()
    }

    fun launchCamera(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
}