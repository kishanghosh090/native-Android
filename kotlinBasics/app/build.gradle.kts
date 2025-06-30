plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.kotlinbasics"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.kotlinbasics"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // LifecycleScope (for activities/fragments)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // LiveData (optional but often used)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // Coroutines core
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

// Coroutines for Android (Dispatchers.Main etc.)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

}