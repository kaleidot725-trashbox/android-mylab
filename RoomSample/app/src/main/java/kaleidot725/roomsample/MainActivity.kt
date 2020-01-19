package kaleidot725.roomsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Default).launch {
    val database =
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name")
            .fallbackToDestructiveMigration()
            .build()
    val userDao = database.userDao()
    val newUser = User(0, Date().time.toString(), Date().time.toString(), null)
    userDao.insert(newUser)
    Log.v("TAG", "after insert ${userDao.getAll().toString()}")

            userDao.deleteAll()
            Log.v("TAG", "after deleteAll ${userDao.getAll().toString()}")
        }
    }
}
