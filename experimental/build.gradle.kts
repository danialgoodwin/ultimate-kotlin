plugins {
    kotlin("jvm")
}

group = "dev.goodwin"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}