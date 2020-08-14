package com.example.toy_project_spring.service

import com.example.toy_project_spring.dao.CategoryRepository
import com.example.toy_project_spring.dao.TalkRepository
import com.example.toy_project_spring.model.AfterCate
import com.example.toy_project_spring.model.Category
import com.example.toy_project_spring.model.Talk
import org.aspectj.lang.annotation.After
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService constructor(
        @Autowired
        private val categoryRepository: CategoryRepository
) {
    fun getCategory(clasnm: String): MutableList<AfterCate> {
        val items: MutableList<Category> = categoryRepository.findByCLASNM(clasnm)
        val category: MutableList<AfterCate> = arrayListOf()
        var tempItem: AfterCate? = null

        (0 until items.size).forEach {
            val item = items[it]
            val hasChild = item.PCATEID != null
            when (item.VISCHILD) {
                true -> {
                    when (item.CATETYP) {
                        0 -> {
                            if (tempItem != null) category.add(tempItem!!)
                            tempItem = AfterCate(item.CATETYP, item.CATENM, hasChild)
                        }
                        1 -> tempItem?.invisibleChildren?.add(AfterCate(item.CATETYP, item.CATENM, hasChild))
                    }
                }
                false -> {
                    when (item.CATECLS == null) {
                        true -> category.add(AfterCate(item.CATETYP, item.CATENM, hasChild))
                        false -> category.add(AfterCate(item.CATETYP, item.CATENM, hasChild).apply {
                            className = item.CATECLS!!
                            isClass = true
                        })
                    }
                }
            }
        }
        if (tempItem != null) category.add(tempItem!!)
        return category
    }
}