package com.example.toy_project_spring.dao

import com.example.toy_project_spring.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Int> {
    fun findByUserid(userid: String): User
}
