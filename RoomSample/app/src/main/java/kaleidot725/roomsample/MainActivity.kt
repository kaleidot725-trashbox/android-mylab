package kaleidot725.roomsample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import kaleidot725.roomsample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var database : AppDatabase
    private lateinit var repository: UserRepository
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").fallbackToDestructiveMigration().build()
        repository = UserRepository(database.userDao())
        viewModel = MainViewModel(repository)
        viewModel.load()

        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}
