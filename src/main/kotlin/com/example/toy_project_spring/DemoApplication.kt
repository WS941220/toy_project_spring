package com.example.toy_project_spring

import com.example.toy_project_spring.service.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.Resource


@SpringBootApplication
class DemoApplication: CommandLineRunner {
	@Resource
	var storageService: StorageService? = null

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(DemoApplication::class.java, *args)
		}
	}
	override fun run(vararg args: String?) {
//		storageService?.deleteAll()
//		storageService?.init()
	}

}

