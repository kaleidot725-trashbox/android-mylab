package kaleidot725.exoplayersample

import android.media.MediaCodecList
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.RenderersFactory
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customCodecSelector = object : MediaCodecSelector {
            override fun getDecoderInfos(mimeType: String?, requiresSecureDecoder: Boolean, requiresTunnelingDecoder: Boolean): MutableList<MediaCodecInfo> {
                return MediaCodecUtil.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder).toMutableList().filter {
                    it.name.startsWith("OMX.google.")
                }.toMutableList()
            }

            override fun getPassthroughDecoderInfo(): MediaCodecInfo? {
                return MediaCodecUtil.getPassthroughDecoderInfo()
            }
        }

        val view = findViewById<PlayerView>(R.id.player_view)
        val trackSelector = DefaultTrackSelector()
        val renderersFactory = DefaultRenderersFactory(this).apply {
            setMediaCodecSelector(customCodecSelector)
        }
        val player = ExoPlayerFactory.newSimpleInstance(this, renderersFactory, trackSelector).apply {
            val uri = Uri.parse("https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_1MB.mp4")
            val dataSource = DefaultDataSourceFactory(this@MainActivity, Util.getUserAgent(this@MainActivity, "ExoPlayerSample"))
            val videoSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)
            prepare(videoSource)
        }
        view.player = player
    }
}
