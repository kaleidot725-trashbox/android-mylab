package kaleidot725.workmanagersample

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(
    private val appContext : Context,
    private val workerParams : WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val id = inputData.getInt("id", -1)
        val name = inputData.getString("name")
        Log.d("SimpleWorker", "do Simple Work(${name})!!")

        val outputData = Data.Builder().putInt("id", id).putString("msg", "End Simple Worker(${name})!!").build()
        return Result.success(outputData)
    }
}