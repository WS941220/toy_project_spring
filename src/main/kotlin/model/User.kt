package model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "YG1_USER")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var username: String = "",
        @JsonIgnore
        var password: String = ""
)