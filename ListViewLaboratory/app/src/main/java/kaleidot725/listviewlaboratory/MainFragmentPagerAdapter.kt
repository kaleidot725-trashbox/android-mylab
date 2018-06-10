package kaleidot725.listviewlaboratory

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kaleidot725.listviewlaboratory.BindingRecyclerView.BindingRecyclerFragment
import kaleidot725.listviewlaboratory.ListView.ListViewFragment
import kaleidot725.listviewlaboratory.RecyclerView.RecyclerViewFragment
import kaleidot725.listviewlaboratory.ViewHolder.ViewHolderFragmenrt

/**
 * Created by kaleidot725 on 2018/01/22.
 */
class MainFragmentPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    val pageCount : Int = 4
    val fm = fm

    override fun getItem(position : Int) : Fragment {
        if (position == 0)
            return ListViewFragment()

        if (position == 1)
            return ViewHolderFragmenrt()

        if (position == 2)
            return RecyclerViewFragment()

        return BindingRecyclerFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0)
            return "ListView"

        if (position == 1)
            return "ViewHolder"

        if (position == 2)
            return "RecyclerView"

        return "BindingRecyclerView"
    }

    override fun getCount() : Int {
        return pageCount
    }
}