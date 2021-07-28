import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "me.lapone"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.telegram:telegrambots:5.3.0")
    implementation("org.telegram:telegrambotsextensions:5.3.0")
//    implementation("org.jooq:jooq:3.15.1")
//    implementation("org.jooq:jooq-meta:3.15.1")
//    implementation("org.jooq:jooq-codegen:3.15.1")
    implementation("org.slf4j:slf4j-simple:1.7.31")
    implementation("org.mybatis:mybatis:3.5.7")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.3.0")
    implementation ("org.postgresql:postgresql:42.2.10")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}