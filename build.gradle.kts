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

}

tasks.test {
    useTestNG()
}