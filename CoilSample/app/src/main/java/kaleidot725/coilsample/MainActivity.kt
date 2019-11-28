package kaleidot725.coilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.Transformation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun loadSimple() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url)
            }
        }

        fun loadCrossfade() {
            val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    crossfade(true)
                }
            }
        }

        fun loadCrossfadeMs() {
            val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    crossfade(3000)
                }
            }
        }

        fun loadPlaceHolder() {
            val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    placeholder(R.drawable.placeholder)
                    crossfade(3000)
                }
            }
        }

        fun loadError() {
            val url = "https://hoge.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    error(R.drawable.error)
                }
            }
        }

        fun loadBlur() {
            val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    transformations(BlurTransformation(context = applicationContext, radius = 20f, sampling = 5f))
                }
            }
        }

        val url = "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
        val imageView = findViewById<ImageView>(R.id.image_view)
        val reloadButton = findViewById<Button>(R.id.reload_button)
        reloadButton.setOnClickListener {
            imageView.load(url) {
                transformations(CircleCropTransformation())
            }
        }

    }
}

