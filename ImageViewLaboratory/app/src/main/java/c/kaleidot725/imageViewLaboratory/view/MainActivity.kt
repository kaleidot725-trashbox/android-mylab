package c.kaleidot725.imageViewLaboratory.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import c.kaleidot725.imageViewLaboratory.viewModel.MainViewModel
import c.kaleidot725.imageViewLaboratory.model.ImageResources
import c.kaleidot725.imageViewLaboratory.R
import c.kaleidot725.imageViewLaboratory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )

        binding?.viewmodel = MainViewModel(ImageResources())
        binding?.setLifecycleOwner(this)
    }
}
