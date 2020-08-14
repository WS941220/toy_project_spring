package com.example.toy_project_spring.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table(name = "TTALK")
data class Talk (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var TALKID: Int,
    var USERID: String,
    var CATEGORY: String,
    var CONTENTS: String,
    var CREDT: String,
    var MODDT: String? = null,
    var DTALK: String? = null,
    var RTALK: String? = null,
    var REFTA1: String? = null,
    var REFTA2: String? = null,
    var REFTA3: String? = null,
    var REFDT1: String? = null,
    var REFDT2: String? = null
)