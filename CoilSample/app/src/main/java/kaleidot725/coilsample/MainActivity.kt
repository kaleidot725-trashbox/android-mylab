package kaleidot725.coilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import coil.Coil
import coil.ImageLoader
import coil.api.load
import coil.transform.*

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
                val disposable = imageView.load(url)
                disposable.dispose()
            }
        }

        fun loadCrossfade() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    crossfade(true)
                }
            }
        }

        fun loadCrossfadeMs() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    crossfade(3000)
                }
            }
        }

        fun loadPlaceHolder() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
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
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    transformations(
                        BlurTransformation(
                            context = applicationContext,
                            radius = 20f,
                            sampling = 5f
                        )
                    )
                }
            }
        }

        fun loadCircleCrop() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    transformations(CircleCropTransformation())
                }
            }
        }

        fun loadGrayScale() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    transformations(GrayscaleTransformation())
                }
            }
        }

        fun loadRoundedCorners() {
            val url =
                "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url) {
                    transformations(
                        RoundedCornersTransformation(
                            topRight = 10f,
                            topLeft = 10f,
                            bottomLeft = 10f,
                            bottomRight = 10f
                        )
                    )
                }
            }

        }

        fun loadUsingImageLoader() {
            val imageLoader = ImageLoader(applicationContext) {
                crossfade(true)
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
                availableMemoryPercentage(0.1)
                bitmapPoolPercentage(0.1)
            }
            val url = "https://notfound.png"
            val imageView = findViewById<ImageView>(R.id.image_view)
            val reloadButton = findViewById<Button>(R.id.reload_button)
            reloadButton.setOnClickListener {
                imageView.load(url, imageLoader)
            }
        }


        Coil.setDefaultImageLoader(ImageLoader(applicationContext) {
            crossfade(true)
            placeholder(R.drawable.placeholder)
            error(R.drawable.error)
            availableMemoryPercentage(0.1)
            bitmapPoolPercentage(0.1)
        })

        val url = "https://notfound.png"
        val imageView = findViewById<ImageView>(R.id.image_view)
        val reloadButton = findViewById<Button>(R.id.reload_button)
        reloadButton.setOnClickListener {
            imageView.load(url)
        }
    }
}

