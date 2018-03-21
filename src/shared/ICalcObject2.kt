package shared

import java.io.Serializable
import java.rmi.Remote
import java.rmi.RemoteException

interface ICalcObject2 : Serializable, Remote {

    @Throws(RemoteException::class)
    fun calculate(param: InputType): ResultType
}