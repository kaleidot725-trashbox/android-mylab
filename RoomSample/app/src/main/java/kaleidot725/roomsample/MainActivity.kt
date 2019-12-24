package kaleidot725.roomsample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.util.AttributeSet
import android.view.View
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        val database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()
        val repository = UserRepository(database.userDao())
        return super.onCreateView(name, context, attrs)
    }
}
