package kaleidot725.headuplaboratory

import android.app.Notification
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.NotificationCompat
import android.app.NotificationManager
import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var channelIdEditText : EditText
    private lateinit var channelNameEditText : EditText
    private lateinit var titleEditText: EditText
    private lateinit var textEditText: EditText
    private lateinit var whenTimePicker : TimePicker
    private lateinit var notifyButton : Button
    private var notifyId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        channelIdEditText = findViewById<EditText>(R.id.et_channelid)
        channelNameEditText = findViewById<EditText>(R.id.et_channelname)
        titleEditText = findViewById<EditText>(R.id.et_text)
        textEditText = findViewById<EditText>(R.id.et_text)
        whenTimePicker = findViewById<TimePicker>(R.id.tm_when)
        notifyButton = findViewById<Button>(R.id.bt_notify)
        notifyButton.setOnClickListener { notification() }
    }

    fun notification() {
        val channelId  = channelIdEditText.text.toString()
        val channelName = channelNameEditText.text.toString()
        val title = titleEditText.text.toString()
        val text = textEditText.text.toString()
        val whenMillSeconds = getTimeInMillisFromTimePicker(whenTimePicker)
        val notificationCompatBuilder: NotificationCompat.Builder
        val notificationManagerCompat : NotificationManagerCompat

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            notificationChannel.enableVibration(true)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            notificationCompatBuilder = NotificationCompat.Builder(this, channelId)
        }
        else {
            notificationCompatBuilder = NotificationCompat.Builder(this)
        }

        notificationCompatBuilder
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(text)
            .setAutoCancel(true)
            .setWhen(whenMillSeconds)

        notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(notifyId, notificationCompatBuilder.build())
        notifyId++
    }

    fun getTimeInMillisFromTimePicker(timePicker : TimePicker) : Long
    {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, whenTimePicker.hour)
        calendar.set(Calendar.MINUTE, whenTimePicker.minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        return calendar.timeInMillis
    }
}
