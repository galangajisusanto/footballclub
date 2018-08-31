package tech.codestudio.footballclub

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DescriptionActivity : AppCompatActivity() {

    private var name: String = ""
    private var deskripsi: String = ""
    private var gambar: Int = 0
    lateinit var nameTextView: TextView
    lateinit var deskripsiTextView: TextView
    lateinit var gambarImageView: ImageView

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.getBundleExtra("myBundle")
        var club = bundle.getParcelable<Club>("cl") as Club

        name = club.name
        deskripsi = club.description
        gambar = club.image.toInt()

        verticalLayout {

            gambarImageView = imageView(gambar).lparams(height = dip(100)) {
                padding = dip(20)
                margin = dip(15)
            }

            nameTextView = textView {
                text = name
                textSize = 14f
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }

            deskripsiTextView = textView {
                text = deskripsi
                textSize = 12f
                padding = dip(15)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }

        }
    }


}
