package kaleidot725.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.formats.UnifiedNativeAdView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AdLoader.Builder(this, "ca-app-pub-6306836711962723/2110270785")
               builder.forUnifiedNativeAd { nativeAd ->
            val view = layoutInflater.inflate(R.layout.unified_nativead_view, null)
            val container = findViewById<FrameLayout>(R.id.nativead_container)

            view.findViewById<TextView>(R.id.ad_headline).text = nativeAd.headline
            view.findViewById<TextView>(R.id.ad_body).text = nativeAd.body
            view.findViewById<TextView>(R.id.ad_call_to_action).text = nativeAd.callToAction

            val icon = nativeAd.icon
            if (icon == null) {
                view.findViewById<ImageView>(R.id.ad_icon).visibility = View.INVISIBLE
            } else {
                view.findViewById<ImageView>(R.id.ad_icon).setImageDrawable(icon.drawable)
                view.findViewById<ImageView>(R.id.ad_icon).visibility = View.VISIBLE
            }

            if (nativeAd.price == null) {
                view.findViewById<TextView>(R.id.ad_price).visibility = View.INVISIBLE
            } else {
                view.findViewById<TextView>(R.id.ad_price).visibility = View.VISIBLE
                view.findViewById<TextView>(R.id.ad_price).text = nativeAd.price
            }

            if (nativeAd.store == null) {
                view.findViewById<TextView>(R.id.ad_store).visibility = View.INVISIBLE
            } else {
                view.findViewById<TextView>(R.id.ad_store).visibility = View.VISIBLE
                view.findViewById<TextView>(R.id.ad_store).text = nativeAd.store
            }

            if (nativeAd.starRating == null) {
                view.findViewById<RatingBar>(R.id.ad_stars).visibility = View.INVISIBLE
            } else {
                view.findViewById<RatingBar>(R.id.ad_stars).rating = nativeAd.starRating.toFloat()
                view.findViewById<RatingBar>(R.id.ad_stars).visibility = View.VISIBLE
            }

            if (nativeAd.advertiser == null) {
                view.findViewById<TextView>(R.id.ad_advertiser).visibility = View.INVISIBLE
            } else {
                view.findViewById<TextView>(R.id.ad_advertiser).text = nativeAd.advertiser
                view.findViewById<TextView>(R.id.ad_advertiser).visibility = View.VISIBLE
            }

            val adView = view as? UnifiedNativeAdView
            adView?.setNativeAd(nativeAd)

            container.removeAllViews()
            container.addView(view)
        }

        MobileAds.initialize(this) {
            val loader = builder.build()
            loader.loadAd(AdRequest.Builder().build())
        }
    }
}
