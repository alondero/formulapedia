buildscript {
    configure(listOf(repositories, project.repositories)) {
        maven {setUrl("https://repo.gradle.org/gradle/repo")}
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
        classpath("org.springframework.boot:spring-boot-gradle-plugin:+")
    }
}

apply {
    plugin("idea")
    plugin("kotlin")
    plugin("org.springframework.boot")
}

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-reflect:+")
    compile(kotlinModule("stdlib"))
    compile("org.springframework.boot:spring-boot-starter-web:+") {
        exclude(module = "spring-boot-starter-tomcat")
    }
    compile("org.springframework.boot:spring-boot-starter-jetty:+")
}

