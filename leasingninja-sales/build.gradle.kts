plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.21"

    //application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.jmolecules:jmolecules-ddd:1.6.0")

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
    //testImplementation("org.jetbrains.kotlin:kotlin-test")
    //testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

/*
application {
    mainClass.set("demo.AppKt")
}
*/
