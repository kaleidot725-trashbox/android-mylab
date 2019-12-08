package c.kaleidot725.safeargssample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass.
 */
class OneFragment : Fragment() {

    val args : OneFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val b = view.findViewById<Button>(R.id.next_button)
        b.setOnClickListener {
            val action = OneFragmentDirections.actionOneFragmentToTwoFragment("Two Fragment")
            this.findNavController().navigate(action)
        }

        val t = view.findViewById<TextView>(R.id.param_view)
        t.text = args.title
    }
}
