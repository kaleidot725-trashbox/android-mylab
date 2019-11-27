package kaleidot725.coilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import coil.api.load

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
        val imageView = findViewById<ImageView>(R.id.image_view)
        imageView.load(url)
    }
}
