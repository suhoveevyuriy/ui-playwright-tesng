plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Source: https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.12.0")
    implementation("com.microsoft.playwright:playwright:1.62.0")

    implementation("org.apache.logging.log4j:log4j-api:2.26.1")
    implementation("org.apache.logging.log4j:log4j-core:2.26.1")


    testImplementation("io.qameta.allure:allure-testng:2.35.5")


}

tasks.test {
    useTestNG()
}