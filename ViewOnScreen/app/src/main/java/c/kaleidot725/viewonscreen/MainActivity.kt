package c.kaleidot725.viewonscreen

import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
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
        scroll_view.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val screenRect = getScreenRect()
            val oneRect = oneTextView.getViewRect()
            if (screenRect.contains(oneRect)) {
                oneTextView.setBackgroundColor(Color.RED)
            } else if (screenRect.intersect(oneRect)) {
                oneTextView.setBackgroundColor(Color.BLUE)
            }

            val twoRect = twoTextView.getViewRect()
            if (screenRect.contains(twoRect)) {
                twoTextView.setBackgroundColor(Color.RED)
            } else if (screenRect.intersect(twoRect)) {
                twoTextView.setBackgroundColor(Color.BLUE)
            }

            val threeRect = threeTextView.getViewRect()
            if (screenRect.contains(threeRect)) {
                threeTextView.setBackgroundColor(Color.RED)
            } else if (screenRect.intersect(threeRect)) {
                threeTextView.setBackgroundColor(Color.BLUE)
            }

            Log.v("TAG", "screen ${screenRect}")
            Log.v("TAG", "one ${oneRect}")
            Log.v("TAG", "two ${twoRect}")
            Log.v("TAG", "three ${threeRect}")
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
        windowManager.defaultDisplay.getSize(point)
        return Rect(0, 0, point.x, point.y)
    }

    private fun View.getViewRect(): Rect {
        val array = IntArray(2)
        this.getLocationOnScreen(array)
        return Rect(array[0], array[1], array[0] + this.width, array[1] + this.height)
    }
}
