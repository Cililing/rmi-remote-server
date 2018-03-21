package shared

import java.rmi.Remote
import java.rmi.RemoteException

interface ICalcObject : Remote {

    @Throws(RemoteException::class)
    fun calculate(a: Double, b: Double): Double
}