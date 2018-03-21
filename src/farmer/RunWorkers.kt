package farmer

import java.rmi.registry.LocateRegistry

fun main(args: Array<String>) {

    val address = "/localhost:80"
    val numberOfWorkers = 3

    if (System.getSecurityManager() == null) {
        System.setSecurityManager(SecurityManager())
    }

    LocateRegistry.createRegistry(1099)

    val workers = List(numberOfWorkers, { WorkerClient() as IWorker })

//  Create workers
    workers.forEachIndexed { index, worker ->
        java.rmi.Naming.rebind("$address/worker$index", worker)
    }

//  Create farmer
    java.rmi.Naming.rebind("$address/min", FarmerClient(numberOfWorkers, address, "worker") as IFarmer)

    readLine()
}