package model

import java.io.Serializable

data class JwtRequest constructor(val username: String, val password: String) : Serializable {
    companion object {
        private const val serialVersionUID = 5926468583005150707L
    }
}