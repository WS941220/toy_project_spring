package com.example.toy_project_spring.service

import com.example.toy_project_spring.dao.ImageRepository
import com.example.toy_project_spring.dao.TalkRepository
import com.example.toy_project_spring.model.Image
import com.example.toy_project_spring.model.Talk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile

@Service
class TalkService constructor(
        @Autowired
        private val talkRepository: TalkRepository,
        @Autowired
        private val imageRepository: ImageRepository
) {
    fun saveTalk(talk: Talk) {
        talkRepository.save(talk)
    }

    fun saveImg(file: MultipartFile): Image {
        val imgName = StringUtils.cleanPath(file.originalFilename.toString())
        val image = Image(IMNAME = imgName, IMTYPE = file.contentType.toString(), IMDATA = file.bytes)

        return imageRepository.save(image)
    }

    fun getImg(id: String): Image {
        return imageRepository.findById(id).get()
    }

}