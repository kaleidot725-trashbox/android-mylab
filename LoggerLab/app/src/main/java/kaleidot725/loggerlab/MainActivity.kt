package kaleidot725.loggerlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.lang.Exception
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.println(Log.ASSERT, "MainActivity", "ASSERT")
        Log.v("TAG", "Message")

        try {
            throw Exception("Unknown Error")
        } catch (e : Exception) {
            Log.v("TAG", "Message", e)
        }

        val verbose = findViewById<Button>(R.id.verbose_button)
        verbose.setOnClickListener {
            Log.v("MainActivity", "verbose")
        }

        val debug = findViewById<Button>(R.id.debug_button)
        debug.setOnClickListener {
            Log.d("MainActivity", "debug")
        }

        val info = findViewById<Button>(R.id.info_button)
        info.setOnClickListener {
            Log.i("MainActivity", "info")
        }

        val warn = findViewById<Button>(R.id.warn_button)
        warn.setOnClickListener {
            Log.w("MainActivity", "warn")
        }

        val error = findViewById<Button>(R.id.error_button)
        error.setOnClickListener {
            Log.e("MainActivity", "error")
        }

        val assert = findViewById<Button>(R.id.assert_button)
        assert.setOnClickListener {
            Log.println(Log.ASSERT, "MainActivity", "Assert")
        }

        val print = findViewById<Button>(R.id.println_button)
        print.setOnClickListener {
            println("Println")
        }

        if (Log.isLoggable("MainActivity", Log.DEBUG)) {
            Log.d("MainActivity", "Good Debug Log")
        }

        Log.println(Log.ASSERT, "MainAcitivty", "VERBOSE : ${Log.isLoggable("MainActivity", Log.VERBOSE)}")
        Log.println(Log.ASSERT, "MainAcitivty", "DEBUG   : ${Log.isLoggable("MainActivity", Log.DEBUG)}")
        Log.println(Log.ASSERT, "MainAcitivty", "INFO    : ${Log.isLoggable("MainActivity", Log.INFO)}")
        Log.println(Log.ASSERT, "MainAcitivty", "WARN    : ${Log.isLoggable("MainActivity", Log.WARN)}")
        Log.println(Log.ASSERT, "MainAcitivty", "ERROR   : ${Log.isLoggable("MainActivity", Log.ERROR)}")
        Log.println(Log.ASSERT, "MainAcitivty", "ASSERT  : ${Log.isLoggable("MainActivity", Log.ASSERT)}")
    }
}
