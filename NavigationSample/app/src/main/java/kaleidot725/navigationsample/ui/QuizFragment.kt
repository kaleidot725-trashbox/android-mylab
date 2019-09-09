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


class QuizFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quiz_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = QuizFragmentArgs.fromBundle(arguments as Bundle).quizId
        val quiz = QuizRepository().findById(id)

        val listView = view.findViewById<ListView>(R.id.choice_list)
        listView.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, quiz.choices)
        listView.setOnItemClickListener { _, _, position, _ ->
            view.findNavController().navigate(
                QuizFragmentDirections.actionQuizFragmentToResultFragment(quiz.result(quiz.choices[position]))
            )
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
