package com.example.toy_project_spring.controllers

import com.example.toy_project_spring.dao.TalkRepository
import com.example.toy_project_spring.model.FileInfo
import com.example.toy_project_spring.model.Image
import com.example.toy_project_spring.model.ResponseMessage
import com.example.toy_project_spring.model.Talk
import com.example.toy_project_spring.service.StorageService
import com.example.toy_project_spring.service.TalkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import java.nio.file.Path
import java.util.stream.Collectors


@RestController
class TalkController constructor(
        @Autowired
        private val talkRepository: TalkRepository,
        @Autowired
        private val talkService: TalkService,
        @Autowired
        private val storageService: StorageService
) {
    @RequestMapping(value = ["/saveTalk"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun saveTalk(@RequestBody talk: Talk): ResponseEntity<Talk> {
        val response = talkRepository.save(talk)
        return ResponseEntity.ok(response)
    }

    @GetMapping(value = ["/allTalk"])
    @Throws(Exception::class)
    fun allTalk(): ResponseEntity<MutableList<Talk>> {
        val response = talkRepository.findAll().map {
            Talk(TALKID = it.TALKID
                    , USERID = it.USERID
                    , CATEGORY = it.CATEGORY
                    , CONTENTS = it.CONTENTS
                    , CREDT = it.CREDT
                    , IMAGE = it.IMAGE.map {
                Image(IMID = MvcUriComponentsBuilder
                        .fromMethodName(TalkController::class.java, "getFile", it.IMID).build().toString())
            }.toMutableList())
        }.toMutableList()
        return ResponseEntity.ok(response)
    }

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<ResponseMessage> {
        var message = ""
        return try {
            talkService.saveImg(file)
            message = "Uploaded the file successfully: " + file.originalFilename
            ResponseEntity.status(HttpStatus.OK).body(ResponseMessage(message))
        } catch (e: Exception) {
            message = "Could not upload the file: " + file.originalFilename + "!"
            ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseMessage(message))
        }
    }

    @GetMapping(value = ["/files"])
    fun getListFiles(): ResponseEntity<List<FileInfo>> {
        val fileInfos = storageService.loadAll()!!.map { path: Path ->
            val filename = path.fileName.toString()
            val url = MvcUriComponentsBuilder
                    .fromMethodName(TalkController::class.java, "getFile", path.fileName.toString()).build().toString()
            FileInfo(filename, url)
        }.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos)
    }

    @GetMapping("/files/{id}")
    @ResponseBody
    fun getFile(@PathVariable id: String): ResponseEntity<ByteArray> {
        val image = talkService.getImg(id)
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.IMNAME + "\"")
                .body(image.IMDATA)
    }

}