package shared

import java.io.Serializable

data class ResultType(val description: String,
                 val result: Double? = null) : Serializable {
    companion object {
        const val serialVersionUID = 102L
    }
}