package com.example.toy_project_spring.model

import javax.persistence.*


@Entity
@Table(name = "TTALK")
data class Talk(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var TALKID: Int,
        var USERID: String,
        var CATEGORY: String,
        var CONTENTS: String,
        var CREDT: String,
        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn(name = "TALKID", insertable = false)
        var IMAGE: MutableList<Image> = arrayListOf(),
        var MODDT: String? = null,
        var DTALK: String? = null,
        var RTALK: String? = null,
        var REFTA1: String? = null,
        var REFTA2: String? = null,
        var REFTA3: String? = null,
        var REFDT1: String? = null,
        var REFDT2: String? = null
)