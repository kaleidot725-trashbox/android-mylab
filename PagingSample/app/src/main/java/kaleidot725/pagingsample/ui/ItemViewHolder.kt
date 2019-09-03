package kaleidot725.pagingsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.pagingsample.data.Item
import kaleidot725.pagingsample.databinding.RecyclerViewItemBinding
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class ItemViewHolder(
    private val parent : ViewGroup,
    private val binding : RecyclerViewItemBinding = create(parent))
    : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent : ViewGroup) : RecyclerViewItemBinding {
            return DataBindingUtil.inflate<RecyclerViewItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recycler_view_item,
                parent,
                false)
        }
    }

    var item : Item? = null

    fun bindTo(item : Item?) {
        this.item = item
        binding.itemName.item_name.text = item?.name
    }
}