package com.example.toy_project_spring.model

import org.hibernate.annotations.Type
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TCATE")
data class Category(
        @Id
        var CATEID: Int,
        var CLASNM: String,
        var CATENM: String,
        var CATETYP: Int,
        var CATECLS: String? = null,
        var PCATEID: Int? = null,
        var SORTSEQ: Int? = null,
        @Type(type = "org.hibernate.type.NumericBooleanType")
        var VISCHILD: Boolean
)

data class AfterCate constructor(
        val type: Int,
        val text: String,
        val child: Boolean
) {
    var invisibleChildren: MutableList<AfterCate> = arrayListOf()
    var className: String = "ui.show_list.ShowListActivity"
    var isClass: Boolean = false
}