package farmer

import java.rmi.Remote
import java.rmi.RemoteException

interface IWorker : Remote {

    @Throws(RemoteException::class)
    fun getMin(arr: IntArray): Int
}
