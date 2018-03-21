package farmer

import java.io.Serializable
import java.rmi.Remote
import java.rmi.RemoteException

interface IFarmer : Remote, Serializable {

    @Throws(RemoteException::class)
    fun compute(array: IntArray): Int
}
