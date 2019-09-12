package kaleidot725.workmanagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startSimpleWorker(Data.Builder().putInt("id", 100).putString("name", "Simple").build())
        startDeferrableSimpleWorker(1000, Data.Builder().putInt("id", 101).putString("name", "Defferable").build())
        startSimpleWorkerWhenHaveConnectedInternet(Data.Builder().putInt("id", 102).putString("name", "ConnectedNetwork").build())
        startSimpleWorkerWhenDeviceCharging(Data.Builder().putInt("id", 103).putString("name", "Charging").build())
        startSimpleWorkerWhenDeviceIsLowBattery(Data.Builder().putInt("id", 104).putString("name", "LowBattery").build())
        startSimpleWorkerWhenDeviceIsDozeMode(Data.Builder().putInt("id", 105).putString("name", "DozeMode").build())
    }

    fun startSimpleWorker(data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).build()
        val workManager = WorkManager.getInstance()

        Log.d("MainActivity", "Start Simple Worker!!")
        workManager.beginUniqueWork("simple", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startDeferrableSimpleWorker(delayms : Long, data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).setInitialDelay(delayms, TimeUnit.MILLISECONDS).build()
        val workManager = WorkManager.getInstance()
        Log.d("MainActivity", "Start Simple Worker(Deferrable)!!")
        workManager.beginUniqueWork("deferrable", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenHaveConnectedInternet(data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED).build()).build()

        val workManager = WorkManager.getInstance()

        Log.d("MainActivity", "Start Simple Worker(Connected Network)!!")
        workManager.beginUniqueWork("constraints", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceCharging(data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresCharging(true).build()).build()

        val workManager = WorkManager.getInstance()

        Log.d("MainActivity", "Start Simple Worker(Charging)!!")
        workManager.beginUniqueWork("charging", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceIsLowBattery(data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresStorageNotLow(true).build()).build()

        val workManager = WorkManager.getInstance()

        Log.d("MainActivity", "Start Simple Worker(Low Battery)!!")
        workManager.beginUniqueWork("lowBattery", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceIsDozeMode(data : Data) {
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresDeviceIdle(true).build()).build()

        val workManager = WorkManager.getInstance()

        Log.d("MainActivity", "Start Simple Worker(Doze Mode)!!")
        workManager.beginUniqueWork("dozeMode", ExistingWorkPolicy.REPLACE, request).enqueue()
    }
}
