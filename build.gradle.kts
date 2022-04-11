plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
}

group = "com.example"
version = "tuningId"
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.4.1")
    implementation("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}