package c.kaleidot725.viewonscreen

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get_button.setOnClickListener {
            printViewPosition("one", one)
            printViewPosition("two", two)
            printViewPosition("three", three)
            printViewPosition("four", four)
            printViewPosition("five", five)
            printViewPosition("six", six)
            printViewPosition("seven", seven)
            printViewPosition("eight", eight)
            printViewPosition("nine", nine)
        }
    }

    private fun printViewPosition(name: String, view: View) {
        val inWindow = view.getLocationPointInWindow()
        val onScreen = view.getLocationPointOnScreen()
        Log.v("ViewOnScreen", "${name} inWindow ${inWindow} onScreen ${onScreen}")
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
}
