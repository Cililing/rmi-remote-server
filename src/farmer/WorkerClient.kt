package farmer

import java.io.Serializable

class WorkerClient : IWorker, Serializable {
    override fun getMin(arr: IntArray): Int {
        return arr.min()!!
    }
}