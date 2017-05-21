
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPluginConvention
import org.gradle.script.lang.kotlin.*

plugins {
    application
}

buildscript {
    repositories {
        mavenCentral()
        gradleScriptKotlin()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.+")
        classpath("com.github.jengelman.gradle.plugins:shadow:1.+")
    }
}

repositories {
    mavenCentral()
    gradleScriptKotlin()
}

configure<ApplicationPluginConvention> {
    mainClassName = "com.github.alondero.formulapedia.ApplicationKt"
}

var configPath: String by extra
configPath = "$rootProject.projectDir/"

apply {
    plugin("kotlin")
    plugin("com.github.johnrengelman.shadow")
}

configure<ShadowJar>("shadowJar") {
    mergeServiceFiles()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.+")
    compile("io.dropwizard:dropwizard-core:1.+")
    compile("com.github.salomonbrys.kodein:kodein:3.+")

    testCompile("junit:junit:+")
}

inline fun <reified C> Project.configure(name: String, configuration: C.() -> Unit) {
    (this.tasks.getByName(name) as C).configuration()
}