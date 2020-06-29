package controllers

import config.JwtTokenUtil
import model.JwtRequest
import model.JwtResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import service.JwtUserDetailsService
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
        authenticate(authenticationRequest.username, authenticationRequest.password)
        val userDetails = userDetailsService!!.loadUserByUsername(authenticationRequest.username)
        val token = jwtTokenUtil!!.generateToken(userDetails)
        return ResponseEntity.ok<Any>(JwtResponse(token))
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        Objects.requireNonNull(username)
        Objects.requireNonNull(password)
        try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}