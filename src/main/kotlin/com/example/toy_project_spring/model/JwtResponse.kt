package com.example.toy_project_spring.model

import java.io.Serializable

data class JwtResponse(val token: String) : Serializable {
    companion object {
        private const val serialVersionUID = -8091879091924046844L
    }

}