package com.example.toy_project_spring.model

import java.io.Serializable

data class JwtRequest constructor(val userid: String, val userpwd: String) : Serializable {
    companion object {
        private const val serialVersionUID = 5926468583005150707L
    }
}