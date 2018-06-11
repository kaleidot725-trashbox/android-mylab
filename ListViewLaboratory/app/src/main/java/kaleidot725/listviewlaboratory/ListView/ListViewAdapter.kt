package kaleidot725.listviewlaboratory.ListView

import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kaleidot725.listviewlaboratory.Person
import kaleidot725.listviewlaboratory.R

class ListViewAdapter(fragmentActivity: FragmentActivity?, resource : Int, list: List<Person>) : ArrayAdapter<Person>(fragmentActivity, resource, list) {
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = inflater.inflate(R.layout.list_item, parent, false)

        val firstNameTextView = view.findViewById<TextView>(R.id.firstName)
        firstNameTextView.text = super.getItem(position).firstName

        val lastNameTextView = view.findViewById<TextView>(R.id.lastName)
        lastNameTextView.text = super.getItem(position).lastName

        val ageTextView = view.findViewById<TextView>(R.id.age)
        ageTextView.text = super.getItem(position).age.toString()

        return view
    }
}