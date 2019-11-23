package kaleidot725.fadeoutfadeintextsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counter = findViewById<TextView>(R.id.counter)
        counter.text = count.toString()

        val plus = findViewById<Button>(R.id.plus)
        plus.setOnClickListener {
            count++
            counter.text = count.toString()
            counter.animation = createFadeInFadeOutAnimatonSet()
        }

        val minus = findViewById<Button>(R.id.minus)
        minus.setOnClickListener {
            count--
            counter.text = count.toString()
            counter.animation = createFadeInFadeOutAnimatonSet()
        }
    }

    private fun createFadeInFadeOutAnimatonSet() : AnimationSet {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator()
        fadeIn.duration = 1000

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator  = AccelerateInterpolator()
        fadeOut.startOffset = 1000
        fadeOut.duration = 1000

        val animation = AnimationSet(false)
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        return animation
    }
}
