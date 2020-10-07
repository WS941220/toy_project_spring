package com.example.toy_project_spring.dao

import com.example.toy_project_spring.model.Image
import com.example.toy_project_spring.model.Talk
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, String> {
}