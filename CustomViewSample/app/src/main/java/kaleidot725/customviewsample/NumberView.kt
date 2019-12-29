package kaleidot725.customviewsample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
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

    fun setNumber(number : Int) {
        this.number = number
        this.invalidate()
        this.requestLayout()
    }

    fun setDisplayMode(displayMode: Int) {
        this.displayMode = displayMode
        this.invalidate()
        this.requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val backgroundPaint = Paint().apply {
            setColor(Color.GREEN)
        }
        canvas?.drawRect(0f, 0f, this.width.toFloat(), this.height.toFloat(), backgroundPaint)

        val textPaint = Paint().apply {
            setColor(Color.BLACK)
            textSize = 50f
        }
        val text = getDisplayNumber(number, displayMode)
        val textWidth = getTextWidth(text, textPaint)
        canvas?.drawText(text, (this.width / 2f) - (textWidth / 2), this.height / 2f, textPaint)
    }

    private fun getTextWidth(text : String, paint : Paint) : Float {
        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)
        return bounds.width().toFloat() + bounds.left.toFloat()
    }

    private fun getDisplayNumber(number : Int, displayMode : Int) : String {
        fun String.replace(vararg pairs: Pair<String, String>): String =
            pairs.fold(this) { acc, (old, new) -> acc.replace(old, new, ignoreCase = true) }

        return when(displayMode) {
            0 -> { number.toString() }
            1 -> { number.toString().replace(
                "0" to "〇", "1" to "一", "2" to "二", "3" to "三", "4" to "四",
                "5" to "五", "6" to "六", "7" to "七", "8" to "八", "9" to "九"
            )
            }
            else -> { "error" }
        }
    }
}
