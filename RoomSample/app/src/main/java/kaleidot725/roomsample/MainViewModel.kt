package kaleidot725.roomsample

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class  MainViewModel(private val repository: UserRepository) : ViewModel() {
    private val _data : MutableLiveData<String> = MutableLiveData()
    val data : LiveData<String> = _data

    fun load() {
        CoroutineScope(Dispatchers.IO).launch {
            update()
        }
    }

    fun addUser(view : View) {
        CoroutineScope(Dispatchers.IO).launch {
            val date = Date()
            repository.insert(User(0, date.time.toString(), date.time.toString()))
            update()
        }
    }

    fun deleteAll(view : View) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteAll()
            update()
        }
    }

    private fun update() {
        val users = repository.getAll()
        var message = ""
        users.forEach { message += it.id.toString() + " " + it.firstName + " " + it.lastName + "\n" }
        _data.postValue(message)
   }
}