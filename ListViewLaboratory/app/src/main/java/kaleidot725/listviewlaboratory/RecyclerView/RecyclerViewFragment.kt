package kaleidot725.listviewlaboratory.RecyclerView

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kaleidot725.listviewlaboratory.Person
import kaleidot725.listviewlaboratory.ViewHolder.ViewHolderAdapter

import kaleidot725.listviewlaboratory.R

class RecyclerViewFragment : Fragment() {
    val values : List<Person> = mutableListOf(
            Person("Mike",   "Ryan", 15),
            Person("Fred",   "Griffin", 20),
            Person("Ruke",   "Mohammed", 30),
            Person("ふじい",  "まきこ", 40),
            Person("あずま",  "りさ" , 31),
            Person("りゅう",  "ふみえ" , 32),
            Person("とりうみ","のりこ" , 34),
            Person("はすみ",  "ちづる" , 46),
            Person("もりたに","かおり" , 25),
            Person("すがわら","けいすけ" , 36),
            Person("すみよし","たつや" , 40),
            Person("かつやま","まさのり" , 33),
            Person("させ",   "まさあき" , 27),
            Person("ふない",    "ゆうすけ" , 35),
            Person("じんぐうじ", "ただゆき" , 36),
            Person("かねひら",   "ともはる" , 25),
            Person("おぶち",     "こうじ" , 24),
            Person("あいやま",   "やすゆき" , 18))

            private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = RecyclerViewAdapter(values)

        recyclerView = view.findViewById<RecyclerView>(R.id.RecyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
