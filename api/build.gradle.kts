plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "it.unicam.cs.vectorrally"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.mockito:mockito-core:3.9.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.openjfx:javafx-controls:$javafx.version")
    implementation("org.openjfx:javafx-fxml:$javafx.version")
}

javafx {
    version = "20"
    modules = listOf("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}
