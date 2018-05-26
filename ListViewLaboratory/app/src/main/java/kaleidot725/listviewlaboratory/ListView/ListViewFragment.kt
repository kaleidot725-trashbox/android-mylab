package kaleidot725.listviewlaboratory.ListView

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import kaleidot725.listviewlaboratory.R

class ListViewFragment : Fragment() {
    val values : List<Int> = IntRange(0, 1000).toList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.ListView)
        listView.adapter = ArrayAdapter<Int>(activity, android.R.layout.simple_expandable_list_item_1, values)
    }
}
