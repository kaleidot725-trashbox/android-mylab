package kaleidot725.workmanagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleButton = findViewById<Button>(R.id.simple_button)
        simpleButton.setOnClickListener {
            startSimpleWorker()
        }

        val deferrableButton = findViewById<Button>(R.id.deferrable_button)
        deferrableButton.setOnClickListener {
            startDeferrableSimpleWorker(1000)
        }

        val connectedInternetButton = findViewById<Button>(R.id.connected_internet_button)
        connectedInternetButton.setOnClickListener {
            startSimpleWorkerWhenHaveConnectedInternet()
        }

        val lowBatteryButton = findViewById<Button>(R.id.low_battery_button)
        lowBatteryButton.setOnClickListener {
            startSimpleWorkerWhenDeviceIsLowBattery()
        }

        val dozeModeButton = findViewById<Button>(R.id.doze_mode_button)
        dozeModeButton.setOnClickListener {
            startSimpleWorkerWhenDeviceIsDozeMode()
        }

        val parallelButton = findViewById<Button>(R.id.parallel_button)
        parallelButton.setOnClickListener {
            startPararellSimpleWorker()
        }

        val mergerButton = findViewById<Button>(R.id.merger_button)
        mergerButton.setOnClickListener {
            startSimpleWorkerInputMerger()
        }

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            cancelSimpleWorker()
        }

        val intervalButton = findViewById<Button>(R.id.interval_button)
        intervalButton.setOnClickListener {
            startIntervalSimpleWorker()
        }
    }

    fun startSimpleWorker() {
        val data = Data.Builder().putInt("id", 100).putString("name", "Simple").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).build()
        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker!!")
        workManager.beginUniqueWork("simple", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startDeferrableSimpleWorker(delayms : Long) {
        val data =  Data.Builder().putInt("id", 101).putString("name", "Defferable").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).setInitialDelay(delayms, TimeUnit.MILLISECONDS).build()
        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })
        Log.d("MainActivity", "Start Simple Worker(Deferrable)!!")
        workManager.beginUniqueWork("deferrable", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenHaveConnectedInternet() {
        val data = Data.Builder().putInt("id", 102).putString("name", "ConnectedNetwork").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED).build()).build()

        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(Connected Network)!!")
        workManager.beginUniqueWork("constraints", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceCharging() {
        val data = Data.Builder().putInt("id", 103).putString("name", "Charging").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresCharging(true).build()).build()

        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(Charging)!!")
        workManager.beginUniqueWork("charging", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceIsLowBattery() {
        val data = Data.Builder().putInt("id", 104).putString("name", "LowBattery").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresStorageNotLow(true).build()).build()

        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })


        Log.d("MainActivity", "Start Simple Worker(Low Battery)!!")
        workManager.beginUniqueWork("lowBattery", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startSimpleWorkerWhenDeviceIsDozeMode() {
        val data = Data.Builder().putInt("id", 105).putString("name", "DozeMode").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>()
            .setInputData(data)
            .setConstraints(Constraints.Builder()
            .setRequiresDeviceIdle(true).build()).build()

        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(Doze Mode)!!")
        workManager.beginUniqueWork("dozeMode", ExistingWorkPolicy.REPLACE, request).enqueue()
    }

    fun startPararellSimpleWorker() {
        val data = Data.Builder().putInt("id", 106).putString("name", "Parallel").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).build()
        val request2 = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).build()

        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        workManager.getWorkInfoByIdLiveData(request2.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(parallel)!!")
        workManager.beginUniqueWork("parallel", ExistingWorkPolicy.REPLACE, listOf(request, request2)).enqueue()
    }

    fun startSimpleWorkerInputMerger() {
        val workManager = WorkManager.getInstance()
        val data = Data.Builder().putInt("id", 100).putString("name", "merger1").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).build()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        val data2 = Data.Builder().putInt("id", 200).putString("name", "merger2").build()
        val request2 = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data2).build()
        workManager.getWorkInfoByIdLiveData(request2.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        val request3 = OneTimeWorkRequestBuilder<SimpleWorker>().setInputMerger(SimpleWorkerInputMerger::class.java).build()
        workManager.getWorkInfoByIdLiveData(request2.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(merger)!!")
        workManager.beginUniqueWork("merger", ExistingWorkPolicy.REPLACE, listOf(request, request2))
            .then(request3)
            .enqueue()
    }

    fun cancelSimpleWorker() {
        val data =  Data.Builder().putInt("id", 101).putString("name", "Cancel").build()
        val request = OneTimeWorkRequestBuilder<SimpleWorker>().setInputData(data).setInitialDelay(1000, TimeUnit.MILLISECONDS).addTag("ssssss").build()
        val workManager = WorkManager.getInstance()
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {
            if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                val outputData = it.outputData
                val id = outputData.getInt("id", -1)
                val msg = outputData.getString("msg")
                Log.d("MainActivity", msg)
            }
        })

        Log.d("MainActivity", "Start Simple Worker(Cancel)!!")
        workManager.beginUniqueWork("cancel", ExistingWorkPolicy.REPLACE, request).enqueue()

        Log.d("MainActivity", "Cancel Simple Worker(Cancel)!!")
        workManager.cancelWorkById(request.id)

        Log.d("MainActivity", "Start Simple Worker(Cancel)!!")
        workManager.beginUniqueWork("cancel", ExistingWorkPolicy.REPLACE, request).enqueue()

        Log.d("MainActivity", "Cancel Simple Worker(Cancel)!!")
        workManager.cancelUniqueWork("cancel")

        Log.d("MainActivity", "Start Simple Worker(Cancel)!!")
        workManager.beginUniqueWork("cancel", ExistingWorkPolicy.REPLACE, request).enqueue()

        Log.d("MainActivity", "Cancel Simple Worker(Cancel)!!")
        workManager.cancelAllWorkByTag("ssssss")
    }

    private var intervalEnable : Boolean = false
    private val data = Data.Builder().putInt("id", 100).putString("name", "Internval").build()
    private val intervalRequest : PeriodicWorkRequest =
        PeriodicWorkRequestBuilder<SimpleWorker>(15, TimeUnit.MINUTES).setInputData(data).build()

    fun startIntervalSimpleWorker() {
        val workManager = WorkManager.getInstance()
        if (!intervalEnable) {
            workManager.getWorkInfoByIdLiveData(intervalRequest.id).observe(this, Observer {
                if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                    val outputData = it.outputData
                    val id = outputData.getInt("id", -1)
                    val msg = outputData.getString("msg")
                    Log.d("MainActivity", msg)
                }
            })

            Log.d("MainActivity", "Start Simple Worker(Periodic)!!")
            workManager.enqueueUniquePeriodicWork("simple", ExistingPeriodicWorkPolicy.REPLACE, intervalRequest)
            intervalEnable = true
        }
        else {
            Log.d("MainActivity", "Cancel Simple Worker(Periodic)!!")
            workManager.cancelWorkById(intervalRequest.id)
            intervalEnable = false
        }

    }
}
