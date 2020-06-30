package com.example.toy_project_spring.service
import com.example.toy_project_spring.dao.UserRepository
import com.example.toy_project_spring.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*


@Service
class JwtUserDetailsService : UserDetailsService {
    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userid: String): UserDetails {
        val user: User = userRepository?.findByUserid(userid)
                ?: throw UsernameNotFoundException("User not found with username: $userid")
        return org.springframework.security.core.userdetails.User(user.userid, user.userpwd,
                ArrayList())
    }
}