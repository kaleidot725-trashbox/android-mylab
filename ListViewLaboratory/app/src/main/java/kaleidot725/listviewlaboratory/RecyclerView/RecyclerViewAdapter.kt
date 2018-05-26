package kaleidot725.listviewlaboratory.RecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class RecyclerViewAdapter(list: List<Int>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val list: List<Int> = list

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position].toString()
    }

    override fun getItemCount(): Int = list.count()
}