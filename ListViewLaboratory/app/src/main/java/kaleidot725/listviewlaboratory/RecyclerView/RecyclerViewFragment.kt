package kaleidot725.listviewlaboratory.RecyclerView

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kaleidot725.listviewlaboratory.ViewHolder.ViewHolderAdapter

import kaleidot725.listviewlaboratory.R

class RecyclerViewFragment : Fragment() {
    val values : List<Int> = IntRange(0, 1000).toList()

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
