package com.example.toy_project_spring.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "TUSER")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var userid: String = "",
        @JsonIgnore
        var userpwd: String = ""
)