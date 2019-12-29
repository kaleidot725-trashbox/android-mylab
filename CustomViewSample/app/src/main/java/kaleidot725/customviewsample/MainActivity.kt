package kaleidot725.customviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberView : NumberView = findViewById(R.id.number_view)
        numberView.setNumber(999999)
        numberView.setDisplayMode(0)
    }
}
