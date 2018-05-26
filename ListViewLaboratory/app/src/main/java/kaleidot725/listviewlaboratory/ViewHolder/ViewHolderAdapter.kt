package kaleidot725.listviewlaboratory.ViewHolder

import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.ArrayAdapter

class ViewHolderAdapter(fragmentActivity: FragmentActivity?, resource : Int, list: List<Int>) : ArrayAdapter<Int>(fragmentActivity, resource, list) {
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(var textView : TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var convertViewTemp : View
        lateinit var viewHolder : ViewHolder

        if (convertView == null) {
            convertViewTemp = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
            viewHolder = ViewHolder(convertViewTemp.findViewById<TextView>(android.R.id.text1))
            convertViewTemp.setTag(viewHolder)
        }
        else {
            convertViewTemp = convertView
            viewHolder = convertViewTemp.getTag() as ViewHolder
        }

        viewHolder.textView.text = super.getItem(position).toString()
        return convertViewTemp
    }
}
