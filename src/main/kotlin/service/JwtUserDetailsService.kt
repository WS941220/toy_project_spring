package service
import dao.UserRepository
import model.User
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
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository?.findByUsername(username)
                ?: throw UsernameNotFoundException("User not found with username: $username")
        return org.springframework.security.core.userdetails.User(user.username, user.password,
                ArrayList())
    }
}