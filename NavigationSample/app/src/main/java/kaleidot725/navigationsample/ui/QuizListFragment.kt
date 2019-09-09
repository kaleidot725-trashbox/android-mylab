package kaleidot725.navigationsample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.findNavController
import kaleidot725.navigationsample.R
import kaleidot725.navigationsample.data.QuizRepository


class QuizListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quiz_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val quizList = QuizRepository().findAll()
        val quizTitles = quizList.map { x -> x.title }

        val listView = view.findViewById<ListView>(R.id.quiz_list)
        listView.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, quizTitles)
        listView.setOnItemClickListener { _, _, position, _ ->
            view.findNavController().navigate(
                QuizListFragmentDirections.actionQuizListFragmentToQuizFragment(quizList[position].id)
            )
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
