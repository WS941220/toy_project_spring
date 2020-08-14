package com.example.toy_project_spring.dao

import com.example.toy_project_spring.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, String> {

    fun findByCLASNM(clasnm: String): MutableList<Category>
}