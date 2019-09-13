package kaleidot725.workmanagersample

import androidx.work.Data
import androidx.work.InputMerger

class SimpleWorkerInputMerger : InputMerger() {
    override fun merge(inputs: MutableList<Data>): Data {
        val id = inputs.map { it.getInt("id", 100) }.max() ?: 100
        val msg = inputs.map { it.getString("key") }.last() + " merged"
        return Data.Builder().putInt("id", id).putString("msg", msg).build()
    }
}