package kaleidot725.roomsample

import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
        GlobalScope.launch(Dispatchers.IO) {
            try {
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

                GlobalScope.launch(Dispatchers.Main) {
                    val textView = findViewById<TextView>(R.id.textView)
                    var concat = ""
                    members.forEach { concat += "${it.id} ${it.displayName}\n" }
                    textView?.text = concat
                }
            } catch(e : Exception) {
                Log.v("TEST", e.toString())
            }
        }

        return super.onCreateView(name, context, attrs)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
