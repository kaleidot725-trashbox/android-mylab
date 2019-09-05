package kaleidot725.safeclicksample

import android.databinding.BindingAdapter
import android.os.SystemClock
import android.view.View

@BindingAdapter("app:onSafeClick")
fun onSafeClick(view: View, listener : View.OnClickListener) {

    class SafeClickListener(
        private var defaultInterval: Int = 1000,
        private val listener : View.OnClickListener) : View.OnClickListener
    {
        private var lastTimeClicked: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
                return
            }
            lastTimeClicked = SystemClock.elapsedRealtime()
            listener.onClick(v)
        }
    }

    view.setOnClickListener(SafeClickListener(1000, listener))
}