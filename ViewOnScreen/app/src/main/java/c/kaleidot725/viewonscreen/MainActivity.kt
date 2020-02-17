package c.kaleidot725.viewonscreen

import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oneTextView = one
        val twoTextView = two
        val threeTextView = three

        scroll_view.viewTreeObserver.addOnScrollChangedListener {
            val screenRect = getScreenRect()

            val oneRect = one.getViewRect()
            val oneColor = if (screenRect.contains(oneRect)) {
                Color.RED
            } else {
                Color.WHITE
            }
            oneTextView.setBackgroundColor(oneColor)

            val twoRect = twoTextView.getViewRect()
            val twoColor = if (screenRect.contains(twoRect)) {
                Color.RED
            } else {
                Color.WHITE
            }
            twoTextView.setBackgroundColor(twoColor)

            val threeRect = threeTextView.getViewRect()
            val threeColor = if (screenRect.contains(threeRect)) {
                Color.RED
            } else {
                Color.WHITE
            }
            threeTextView.setBackgroundColor(threeColor)
        }
    }

    private fun getViewLocationInWindowString(name: String, view: View): String {
        val inWindow = view.getLocationPointInWindow()
        return "${name} inWindow ${inWindow}"
    }

    private fun toastAllViewLocationInWindow() {
        var str = getViewLocationInWindowString("one", one) + "\n"
        str += getViewLocationInWindowString("two", two) + "\n"
        str += getViewLocationInWindowString("three", three) + "\n"
        Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
    }

    private fun toastAllViewLocationOnScreen() {
        var str = getViewLocationOnScreenString("one", one) + "\n"
        str += getViewLocationOnScreenString("two", two) + "\n"
        str += getViewLocationOnScreenString("three", three) + "\n"
        Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
    }

    private fun getViewLocationOnScreenString(name: String, view: View): String {
        val onScreen = view.getLocationPointOnScreen()
        return "${name} onScreen ${onScreen}"
    }

    private fun View.getLocationPointInWindow(): Point {
        val array = IntArray(2)
        this.getLocationInWindow(array)
        return Point(array[0], array[1])
    }

    private fun View.getLocationPointOnScreen(): Point {
        val array = IntArray(2)
        this.getLocationOnScreen(array)
        return Point(array[0], array[1])
    }

    private fun getScreenRect(): Rect {
        val point = Point()
        windowManager.defaultDisplay.getRealSize(point)
        return Rect(0, 0, point.x, point.y)
    }

    private fun View.getViewRect(): Rect {
        val array = IntArray(2)
        this.getLocationOnScreen(array)
        return Rect(array[0], array[1], array[0] + this.width, array[1] + this.height)
    }
}
