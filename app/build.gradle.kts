plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.mypdfsigner.testcasessampleapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mypdfsigner.testcasessampleapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.gson)
    androidTestImplementation ("androidx.test:core-ktx:1.5.0")
    androidTestImplementation ("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation ("androidx.test:runner:1.5.2")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.7.0")

    val room_version = "2.7.2"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")

    testImplementation("androidx.room:room-testing:$room_version") // Or the latest stable version
    androidTestImplementation("androidx.room:room-testing:$room_version") // For instrumented tests
    testImplementation("androidx.arch.core:core-testing:2.2.0") // For testing LiveData and other Architecture Components
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")

    // Mockito
    val mockitoVersion = "5.10.0"
    val mockitoKotlinVersion = "4.0.0"
    testImplementation ("org.mockito:mockito-core:$mockitoVersion")
    // Optional -- mockito-kotlin
    testImplementation ("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation ("org.mockito:mockito-inline:5.2.0")

}