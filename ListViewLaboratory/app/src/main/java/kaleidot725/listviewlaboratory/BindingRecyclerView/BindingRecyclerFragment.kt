package kaleidot725.listviewlaboratory.BindingRecyclerView

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import kaleidot725.listviewlaboratory.Person

import kaleidot725.listviewlaboratory.R
import kaleidot725.listviewlaboratory.RecyclerView.RecyclerViewAdapter

class BindingRecyclerFragment : Fragment() {
    val values : List<Person> = mutableListOf(
            Person("Mike", "Ryan", 10),
            Person("Fred", "Griffin", 20),
            Person("Ruke", "Mohammed", 30))
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_binding_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = BindingRecyclerViewAdapter(values)
        val listView = view.findViewById<RecyclerView>(kaleidot725.listviewlaboratory.R.id.RecyclerViewForBinding).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}