package com.example.toy_project_spring.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "TIMAGE")
data class Image(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        var IMID: String? = null,
        var IMNAME: String? = null,
        var IMTYPE: String? = null,
        @Lob
        var IMDATA: ByteArray = byteArrayOf(),
        var TALKID: String? = null,
        var USERID: String? = null,
        var REFTI1: String? = null,
        var REFTI2: String? = null,
        var REFTI3: String? = null

)
