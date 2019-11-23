package kaleidot725.autosizingtextviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sizeTypeUniformView = findViewById<TextView>(R.id.size_type_uniform_view)
        val minMaxGranularityView = findViewById<TextView>(R.id.min_max_granularity_view)
        val sizePresetSizesView = findViewById<TextView>(R.id.size_preset_sizes_view)

        val sizeSeekBar = findViewById<SeekBar>(R.id.size_seek_bar)
        sizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                sizeTypeUniformView.updateHeight(progress)
                minMaxGranularityView.updateHeight(progress)
                sizePresetSizesView.updateHeight(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) { }
            override fun onStopTrackingTouch(p0: SeekBar?) { }
        })
    }

    private fun TextView.updateHeight(height: Int) {
        val params = this.layoutParams
        params.height = height
        this.layoutParams = params
    }
}
