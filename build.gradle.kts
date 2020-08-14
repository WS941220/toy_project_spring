import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.61"
	id ("org.jetbrains.kotlin.plugin.allopen") version "1.3.61"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {	
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-data")
	implementation("org.springframework.security:spring-security-test")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.71")
	implementation("org.jetbrains.kotlin:kotlin-script-runtime")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.jsonwebtoken:jjwt:0.9.0")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
}

tasks.withType<Test> {	
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.getByName<BootRun>("bootRun") {
	main = "com.example.toy_project_spring.DemoApplicationKt"
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}