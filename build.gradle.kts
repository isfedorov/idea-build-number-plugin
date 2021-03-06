import org.jetbrains.intellij.tasks.PatchPluginXmlTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven("https://cache-redirector.jetbrains.com/plugins.gradle.org/m2")
        maven("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/intellij-plugin-service")
    }
}

group = "me.artspb.idea.build.number.plugin"
version = "1.0"

val ideaVersion: String by extra
val pluginRepositoryToken: String by extra

plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.intellij") version "0.4.21"
}

repositories {
    maven("https://cache-redirector.jetbrains.com/jcenter.bintray.com")
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

intellij {
    version = ideaVersion
}

tasks.withType<PatchPluginXmlTask> {
    sinceBuild("201.6251.9")
    untilBuild("202.*")
}
