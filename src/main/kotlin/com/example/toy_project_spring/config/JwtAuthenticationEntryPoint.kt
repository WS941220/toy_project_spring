package com.example.toy_project_spring.config

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import java.io.Serializable
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint, Serializable {
    companion object {
        private const val serialVersionUID = -7858869558953243875L
    }
    @Throws(IOException::class)
    override fun commence(request: HttpServletRequest, response: HttpServletResponse,
                          authException: AuthenticationException) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
    }
}