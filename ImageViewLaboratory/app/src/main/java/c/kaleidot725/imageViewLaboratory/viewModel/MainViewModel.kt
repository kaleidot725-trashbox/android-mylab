package c.kaleidot725.imageViewLaboratory.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import c.kaleidot725.imageViewLaboratory.model.ImageResources

class MainViewModel(resources : ImageResources) : ViewModel() {

    val resource : MutableLiveData<Int> = MutableLiveData()
    val bitmap : MutableLiveData<Bitmap> = MutableLiveData()
    val drawable : MutableLiveData<Drawable> = MutableLiveData()

    private val resources : ImageResources = resources

    init {
        resource.postValue(resources.get())
    }

    fun next(view : View)
    {
        resource.postValue(resources.next())
    }

    fun back(view : View)
    {
        resource.postValue(resources.back())
    }
}