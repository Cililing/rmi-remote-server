package server

import shared.ResultType
import shared.ICalcObject2
import shared.InputType

class CalcObject2 : ICalcObject2 {

    override fun calculate(param: InputType): ResultType {
        val result = when (param.operation) {
            "add" -> param.x1 + param.x2
            "sub" -> param.x1 - param.x2
            else -> null
        }

        return ResultType("Operation: ${param.operation}", result)
    }

}