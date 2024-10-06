plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "dev.kruchkovenko.id.world.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.kruchkovenko.id.world.test"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    flavorDimensions += listOf("client", "store")
    productFlavors {
        create("GooglePlay") {
            dimension = "store"
            applicationIdSuffix = ".gms"
        }
        create("AppGallery") {
            dimension = "store"
            applicationIdSuffix = ".hms"
        }
        create("OperatorA") {
            dimension = "client"
            applicationId =  "id.world.test.operatorA"
        }
        create("OperatorB") {
            dimension = "client"
            applicationId =  "id.world.test.operatorB"
        }
        create("OperatorC") {
            dimension = "client"
            applicationId =  "id.world.test.operatorC"
        }
        create("OperatorD") {
            dimension = "client"
            applicationId =  "id.world.test.operatorD"
        }
        create("OperatorF") {
            dimension = "client"
            applicationId =  "id.world.test.operatorF"
        }
        create("OperatorG") {
            dimension = "client"
            applicationId =  "id.world.test.operatorG"
        }
        create("OperatorH") {
            dimension = "client"
            applicationId =  "id.world.test.operatorH"
        }
        create("OperatorI") {
            dimension = "client"
            applicationId =  "id.world.test.operatorI"
        }
        create("OperatorJ") {
            dimension = "client"
            applicationId =  "id.world.test.operatorJ"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))
}
