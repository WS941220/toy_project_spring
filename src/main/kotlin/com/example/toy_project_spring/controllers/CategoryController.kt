package com.example.toy_project_spring.controllers

import com.example.toy_project_spring.dao.CategoryRepository
import com.example.toy_project_spring.model.AfterCate
import com.example.toy_project_spring.model.Category
import com.example.toy_project_spring.service.CategoryService
import com.example.toy_project_spring.service.TalkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController constructor(
        @Autowired
        private val categoryRepository: CategoryRepository,

        @Autowired
        private val categorService: CategoryService
) {
    @RequestMapping(value = ["/talkCategory/{clasnm}"], method = [RequestMethod.GET])
    @Throws(Exception::class)
    fun talkCategory(@PathVariable(value = "clasnm") clasnm: String): MutableList<AfterCate> {
        return categorService.getCategory(clasnm)
    }
}