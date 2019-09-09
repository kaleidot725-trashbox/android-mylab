package kaleidot725.navigationsample.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kaleidot725.navigationsample.R


class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val result = ResultFragmentArgs.fromBundle(arguments as Bundle).quizResult
        val resultView = view.findViewById<TextView>(R.id.result_view)
        resultView.text = if (result) context!!.getString(R.string.correct) else context!!.getString( R.string.incorrect)
        super.onViewCreated(view, savedInstanceState)
    }
}
