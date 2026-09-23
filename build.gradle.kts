plugins {
    id("java")
    id("io.qameta.allure") version "4.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.12.0")
    implementation("com.microsoft.playwright:playwright:1.62.0")

    implementation("org.apache.logging.log4j:log4j-api:2.26.1")
    implementation("org.apache.logging.log4j:log4j-core:2.26.1")

    implementation("io.qameta.allure:allure-testng:2.35.5")
    testImplementation("net.datafaker:datafaker:2.7.0")

    implementation("io.rest-assured:rest-assured:6.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

}

val requestedGroups = providers.gradleProperty("groups").orNull

tasks.test {
    useTestNG {
        if (!requestedGroups.isNullOrBlank()) {
            includeGroups(
                *requestedGroups
                    .split(",")
                    .map { it.trim() }
                    .filter { it.isNotEmpty() }
                    .toTypedArray()
            )
        }
    }

    testLogging {
        events("passed", "skipped", "failed")
    }
}