package shared

import java.io.Serializable

data class InputType(val operation: String,
                val x1: Double,
                val x2: Double) : Serializable {
    companion object {
        const val serialVersionUID = 101L
    }
}