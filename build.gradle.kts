import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "me.matt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.reflections", "reflections", "0.10.2")
    implementation("org.slf4j:slf4j-nop:2.0.4")

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.9.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.9.1")
    testImplementation("org.hamcrest", "hamcrest", "2.2")
    testImplementation ("com.github.stefanbirkner:system-lambda:1.2.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}