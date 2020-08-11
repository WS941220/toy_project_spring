package com.example.toy_project_spring.service

import com.example.toy_project_spring.dao.TalkRepository
import com.example.toy_project_spring.model.Talk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TalkService constructor(
        @Autowired
        private val talkRepository: TalkRepository
) {
    fun saveTalk(talk: Talk) {
        talkRepository.save(talk)
    }

}