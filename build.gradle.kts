plugins {
    id("java")
    id("application")
}

group = "edu"
version = "0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("cryptocrack.Main")
    mainModule.set("cryptocrack")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}

dependencies {
}
