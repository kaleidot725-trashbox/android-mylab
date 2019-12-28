package kaleidot725.customviewsample

import android.content.Context
import android.util.AttributeSet
import android.view.View

class NumberView(context : Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var number : Int = 0
    private var displayMode : Int = 0

    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.NumberView, 0, 0).apply {
            try {
                number = getInteger(R.styleable.NumberView_number, 0)
                displayMode = getInteger(R.styleable.NumberView_displayMode, 0)
            } finally {
                recycle()
            }
        }
    }
}
