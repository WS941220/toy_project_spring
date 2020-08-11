package com.example.toy_project_spring.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table(name = "TTALK")
data class Talk (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TALKID")
    var TALKID: String = "",
    var USERID: String = "",
    var CATEGORY: String = "",
    var CONTENTS: String = "",
    var WTIME: String = "",
    var MTIME: String = "",
    var DTALK: String = "",
    var RTALK: String = "",
    var REFTA1: String = "",
    var REFTA2: String = "",
    var REFTA3: String = "",
    var REFDT1: String = "",
    var REFDT2: String = ""
)