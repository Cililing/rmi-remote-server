package farmer

import java.io.Serializable

class FarmerClient(private val workersNumbers: Int,
                   private val address: String,
                   private val workerPrefix: String) : IFarmer, Serializable {

    private val workers = Array<IWorker?>(workersNumbers, { null });

    init {
        (0 until workersNumbers).forEach {
            workers[it] = (java.rmi.Naming.lookup("$address/$workerPrefix$it") as IWorker)
        }
    }

    override fun compute(array: IntArray): Int {
//         Split array
        val splitted = array.toList().chunked(array.size/ workersNumbers).map { x -> x.toIntArray() }

        val results = mutableListOf<Int>()

        workers.forEachIndexed { index, worker ->
            results.add(worker?.getMin(splitted[index]) ?: -1)
        }

        return results.min()!!
    }
}