plugins {
    id("java")
}

group = "de.muv1n"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.purpurmc.org/snapshots")
}

dependencies {
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.20.4-R0.1-SNAPSHOT")
}
tasks.withType(JavaCompile::class.java) {
    options.encoding = "UTF-8"
}

