package server

import shared.ICalcObject
import shared.ICalcObject2
import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry

class Server {

    private val workerInstances = listOf(
            Pair("/localhost:80/c1", lazy { CalcObject() as ICalcObject }),
            Pair("/localhost:80/c2", lazy { CalcObject2() as ICalcObject2 }))

    @Throws(RemoteException::class)
    fun createOwnRegistry(port: Int) {
        val registry = LocateRegistry.createRegistry(port)
    }

    fun configureServer() {
        workerInstances.forEach {
            try {
                java.rmi.Naming.rebind(it.first, it.second.value)
            } catch (ex: Exception) {
                println("Error while creating ${it.first}: $ex")
            }
        }
    }
}

fun main(args: Array<String>) {
    println(System.getProperty("java.security.policy"))

    if (System.getSecurityManager() == null) {
        System.setSecurityManager(SecurityManager())
    }

    val server = Server()
    server.createOwnRegistry(1099)
    server.configureServer()
}


