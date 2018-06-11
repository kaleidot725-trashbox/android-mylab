package kaleidot725.listviewlaboratory.RecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kaleidot725.listviewlaboratory.Person

class RecyclerViewAdapter(list: List<Person>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val list: List<Person> = list

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val firstnameTextView          : TextView    = itemView.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.firstName)
        val lastNameTextView           : TextView    = itemView.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.lastName)
        val ageTextView                : TextView    = itemView.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(kaleidot725.listviewlaboratory.R.layout.list_item, parent, false) as View
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstnameTextView.text = list[position].firstName
        holder.lastNameTextView.text = list[position].lastName
        holder.ageTextView.text = list[position].age.toString()
    }

    override fun getItemCount(): Int = list.count()
}