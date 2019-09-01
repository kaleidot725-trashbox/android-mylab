package kaleidot725.roomsample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        runBlocking {
            GlobalScope.launch(Dispatchers.IO) {
                val memberDao = MyDatabase.getInstance(context as Context).memberDao()
                var members = memberDao.getAllMembsers()
                if (members.count() <= 0) {
                    memberDao.insert(Member("0", "NAME0"))
                    memberDao.insert(Member("1", "NAME1"))
                    memberDao.insert(Member("2", "NAME2"))
                    memberDao.insert(Member("3", "NAME3"))
                    memberDao.insert(Member("4", "NAME4"))
                    memberDao.insert(Member("5", "NAME5"))
                    memberDao.insert(Member("6", "NAME6"))
                    memberDao.insert(Member("7", "NAME7"))
                    memberDao.insert(Member("8", "NAME8"))
                    memberDao.insert(Member("9", "NAME9"))
                    members = memberDao.getAllMembsers()
                }

                for(member in members) {
                    Log.v("", member.toString())
                }
            }
        }

        return super.onCreateView(name, context, attrs)
    }
}
