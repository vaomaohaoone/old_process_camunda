import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") version "2.7.12"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.barfuin.gradle.taskinfo") version "2.1.0"
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.jpa") version "1.8.10"
    kotlin("plugin.spring") version "1.8.10"
    kotlin("kapt") version "1.8.10"
    application
}

group = "me.kirill_timofeev"
version = "1.0-SNAPSHOT"
val camundaVersion = "7.15.0"
val log4jVersion: String = "2.17.2"

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES) {
            bomProperty("kotlin.version", "1.8.10")
        }
    }
}

repositories {
    mavenCentral()
}

configurations {
    all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.camunda.bpm:camunda-engine-rest-openapi:$camundaVersion")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:$camundaVersion")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:$camundaVersion")
    implementation("org.postgresql:postgresql:42.3.8")
    implementation("org.flywaydb:flyway-core")
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")
    implementation("org.springframework.retry:spring-retry")
    implementation("javax.activation:javax.activation-api:1.2.0")

    implementation("org.springframework.boot:spring-boot-starter-log4j2") {
        exclude("org.apache.logging.log4j:log4j-jul")
        exclude("org.apache.logging.log4j:log4j-sl4j-impl")
    }
    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.0.0")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-jul:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=ignore")
            jvmTarget = "11"
        }
    }

    withType<JavaCompile> {
        targetCompatibility = "11"
        sourceCompatibility = "11"
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("org.sample.home.Application.kt")
}