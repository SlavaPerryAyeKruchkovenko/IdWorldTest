plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    //Di
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(project(":domain"))
}
