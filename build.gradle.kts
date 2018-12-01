import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
}

group = "com.madacyn"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.ginsberg:cirkle:1.0.1")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.1.10")
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.10") {
            because("kotlintest-core depends on an older version of kotlin-reflect")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}