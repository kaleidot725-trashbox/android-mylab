package kaleidot725.listviewlaboratory.ViewHolder

import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.ArrayAdapter
import kaleidot725.listviewlaboratory.R.id
import kaleidot725.listviewlaboratory.Person

class ViewHolderAdapter(fragmentActivity: FragmentActivity?, resource : Int, list: List<Person>) : ArrayAdapter<Person>(fragmentActivity, resource, list) {
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(var firstNameTextView : TextView, var lastNameTextView : TextView, var ageTextView : TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var convertViewTemp : View
        lateinit var viewHolder : ViewHolder

        if (convertView == null) {
            convertViewTemp = inflater.inflate(kaleidot725.listviewlaboratory.R.layout.list_item, parent, false)

            val firstNameTextView = convertViewTemp.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.firstName)
            val lastNameTextView = convertViewTemp.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.lastName)
            val ageTextView = convertViewTemp.findViewById<TextView>(kaleidot725.listviewlaboratory.R.id.age)
            viewHolder = ViewHolder(firstNameTextView, lastNameTextView, ageTextView)
            convertViewTemp.setTag(viewHolder)
        }
        else {
            convertViewTemp = convertView
            viewHolder = convertViewTemp.getTag() as ViewHolder
        }

        viewHolder.firstNameTextView.text = super.getItem(position).firstName
        viewHolder.lastNameTextView.text = super.getItem(position).lastName
        viewHolder.ageTextView.text = super.getItem(position).age.toString()
        return convertViewTemp
    }
}
