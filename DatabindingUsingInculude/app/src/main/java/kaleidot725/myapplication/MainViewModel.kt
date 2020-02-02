package kaleidot725.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _activityLayoutMessage: MutableLiveData<String> = MutableLiveData("This is")
    val activityLayoutMessage: LiveData<String> = _activityLayoutMessage

    private val _oneLayoutMessage: MutableLiveData<String> = MutableLiveData("Good Sample")
    val oneLayoutMessage: LiveData<String> = _oneLayoutMessage
}