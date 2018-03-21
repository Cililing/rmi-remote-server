package server

import shared.ICalcObject
import java.rmi.server.UnicastRemoteObject

class CalcObject : UnicastRemoteObject(), ICalcObject {
    companion object {
        const val serialVersionUID = 101L
    }

    override fun calculate(a: Double, b: Double): Double {
        return a + b
    }
}