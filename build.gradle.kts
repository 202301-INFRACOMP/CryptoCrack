plugins {
    java
    application
    id("com.diffplug.spotless") version "6.18.0"
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

spotless {
    encoding("UTF-8")
    java {
        googleJavaFormat().reflowLongStrings()
        formatAnnotations()
    }
    kotlinGradle {

    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.withType(JavaCompile::class).configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

repositories {
    mavenCentral()
}