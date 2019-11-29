package kaleidot725.exoplayersample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<PlayerView>(R.id.player_view)
        val player = ExoPlayerFactory.newSimpleInstance(this).apply {
            val uri = Uri.parse("https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_1MB.mp4")
            val dataSource = DefaultDataSourceFactory(this@MainActivity, Util.getUserAgent(this@MainActivity, "ExoPlayerSample"))
            val videoSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)
            prepare(videoSource)
        }
        view.player = player
    }
}
