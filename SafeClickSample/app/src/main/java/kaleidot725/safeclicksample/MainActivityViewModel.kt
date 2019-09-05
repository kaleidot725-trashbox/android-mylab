package kaleidot725.safeclicksample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View

class MainActivityViewModel : ViewModel() {
    private val counter : Counter = Counter()
    private val _count : MutableLiveData<String> = MutableLiveData()
    val count : LiveData<String>  get() = _count

    init {
        _count.value = counter.num.toString()
    }

    fun plus(v : View) {
        counter.plus()
        _count.value = counter.num.toString()
    }

    fun minus(v : View) {
        counter.minus()
        _count.value = counter.num.toString()
    }
}