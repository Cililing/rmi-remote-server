package client

import shared.ICalcObject
import shared.ICalcObject2
import shared.InputType

fun main(args: Array<String>) {
    val address1 = "/localhost:80/c1"
    val address2 = "/localhost:80/c2"

    tryExecute {
        val instance = java.rmi.Naming.lookup(address1) as ICalcObject
        println(instance.calculate(1.0, 2.0))
    }

    tryExecute {
        val instance = java.rmi.Naming.lookup(address2) as ICalcObject2
        println(instance.calculate(InputType("add", 0.0, 0.3)))
    }
}

fun tryExecute(function: () -> Any) {
    try {
        function.invoke()
    } catch(ex: Exception) {
        println(ex)
    }
}