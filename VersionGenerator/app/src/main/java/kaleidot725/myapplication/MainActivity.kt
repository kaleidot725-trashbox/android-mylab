package kaleidot725.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val packageInfo = packageManager.getPackageInfo(packageName, 0);
        val version = packageInfo.versionName

        val versionView = findViewById<TextView>(R.id.version_text)
        versionView.text = version
    }
}
