package com.example.toy_project_spring.controllers

import com.example.toy_project_spring.config.JwtTokenUtil
import com.example.toy_project_spring.model.JwtRequest
import com.example.toy_project_spring.model.JwtResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import com.example.toy_project_spring.service.JwtUserDetailsService
import java.util.*



@RestController
class JwtAuthenticationController {

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtTokenUtil: JwtTokenUtil? = null
    @Autowired
    private val userDetailsService: JwtUserDetailsService? = null

    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: JwtRequest): ResponseEntity<*> {
        authenticate(authenticationRequest.userid, authenticationRequest.userpwd)
        val userDetails = userDetailsService!!.loadUserByUsername(authenticationRequest.userid)
        val token = jwtTokenUtil!!.generateToken(userDetails)
        return ResponseEntity.ok<Any>(JwtResponse(token))
    }

    @Throws(Exception::class)
    private fun authenticate(userid: String, userpwd: String) {
        Objects.requireNonNull(userid)
        Objects.requireNonNull(userpwd)
        try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(userid, userpwd))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}