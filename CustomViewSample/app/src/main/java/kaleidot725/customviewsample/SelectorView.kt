package kaleidot725.customviewsample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class SelectorView(context : Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    val oneButton : Button
    val twoButton : Button
    val threeButton : Button

    init {
        View.inflate(context, R.layout.selector_view, this)

        oneButton = findViewById(R.id.one)
        twoButton = findViewById(R.id.two)
        threeButton = findViewById(R.id.three)

        oneButton.setOnClickListener {
            oneButton.setTextColor(Color.RED)
            twoButton.setTextColor(Color.BLACK)
            threeButton.setTextColor(Color.BLACK)
        }

        twoButton.setOnClickListener {
            oneButton.setTextColor(Color.BLACK)
            twoButton.setTextColor(Color.RED)
            threeButton.setTextColor(Color.BLACK)
        }

        threeButton.setOnClickListener {
            oneButton.setTextColor(Color.BLACK)
            twoButton.setTextColor(Color.BLACK)
            threeButton.setTextColor(Color.RED)
        }
    }
}