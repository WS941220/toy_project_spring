package com.example.toy_project_spring.controllers

import com.example.toy_project_spring.dao.TalkRepository
import com.example.toy_project_spring.model.Talk
import com.example.toy_project_spring.service.TalkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class TalkController constructor(
        @Autowired
        private val talkRepository: TalkRepository
) {
    @RequestMapping(value = ["/saveTalk"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun saveTalk(@RequestBody talk: Talk): ResponseEntity<Talk> {
        val response = talkRepository.save(talk)
        return ResponseEntity.ok(response)
    }

    @RequestMapping(value = ["/allTalk"])
    @Throws(Exception::class)
    fun allTalk(): List<Talk> {
        return talkRepository.findAll()
    }
}