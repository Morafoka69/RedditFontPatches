plugins {
    alias(libs.plugins.android.library) apply false
    id("app.morphe.patches-gradle-plugin") version "1.5.0"
}

repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/MorpheApp/registry")
    }
}

patches {
    about {
        name = "Custom Reddit Typography"
        description = "Forces system fonts and custom SP sizes on Reddit."
        version = "1.0.0"
    }
}
