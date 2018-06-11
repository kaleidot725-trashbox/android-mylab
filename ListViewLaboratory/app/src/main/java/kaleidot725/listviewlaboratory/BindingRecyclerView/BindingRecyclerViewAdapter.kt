package kaleidot725.listviewlaboratory.BindingRecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kaleidot725.listviewlaboratory.Person
import android.databinding.DataBindingUtil
import kaleidot725.listviewlaboratory.databinding.ListItemBindableBinding

class BindingRecyclerViewAdapter(list: List<Person>) : RecyclerView.Adapter<BindingRecyclerViewAdapter.ViewHolder>() {
    private val list: List<Person> = list

    class ViewHolder(binding : ListItemBindableBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding : ListItemBindableBinding = binding

        fun bind (person : Person) {
            binding.person = person
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBindableBinding>(layoutInflater, kaleidot725.listviewlaboratory.R.layout.list_item_bindable, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.count()
}