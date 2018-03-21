package farmer

import java.rmi.Naming

fun main(args: Array<String>) {

    val farmer: IFarmer
    var result: Int? = null

    val array = (75..100000 step 3).shuffled().toIntArray()

    val address = "/localhost:80/min"

    // //use this if needed
    // if (System.getSecurityManager() == null)
    // System.setSecurityManager(new SecurityManager());

    try {
        farmer = Naming.lookup(address) as IFarmer
    } catch (e: Exception) {
        e.printStackTrace()
        return
    }

    try {
        result = farmer.compute(array)
    } catch (e: Exception) {
        e.printStackTrace()
        return
    }

    println("Result: " + result)
}