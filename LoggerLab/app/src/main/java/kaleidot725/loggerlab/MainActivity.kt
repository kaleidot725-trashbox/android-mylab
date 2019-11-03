package kaleidot725.loggerlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verbose = findViewById<Button>(R.id.verbose_button)
        verbose.setOnClickListener {
            Log.v("MainActivity", "verbose")
        }

        val warn = findViewById<Button>(R.id.warn_button)
        warn.setOnClickListener {
            Log.w("MainActivity", "warn")
        }

        val info = findViewById<Button>(R.id.info_button)
        info.setOnClickListener {
            Log.i("MainActivity", "info")
        }

        val assert = findViewById<Button>(R.id.assert_button)
        assert.setOnClickListener {
            Log.wtf("MainActvity", "Assert")
        }

        val debug = findViewById<Button>(R.id.debug_button)
        debug.setOnClickListener {
            Log.d("MainActivity", "debug")
        }

        val error = findViewById<Button>(R.id.error_button)
        error.setOnClickListener {
            Log.e("MainActivity", "error")
        }
    }
}
