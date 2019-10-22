package kaleidot725.injectbuildvariablessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.pm.PackageManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val apiKey = appInfo.metaData.getString("API_KEY")

        val textView = findViewById<TextView>(R.id.meta_value_textview)
        textView.text = apiKey
    }
}
