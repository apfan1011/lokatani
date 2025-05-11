plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.lokatani"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.lokatani"
        minSdk = 26
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

    // Konfigurasi Compose
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14" // Sesuaikan dengan BOM atau gunakan versi terbaru (misal: 1.5.14 saat Mei 2025)
    }
}

dependencies {
    // Core KTX
    implementation(libs.androidx.core.ktx)
    implementation("androidx.compose.material:material-icons-extended")
    implementation(libs.firebase.auth)

    // Compose BOM untuk mengelola versi secara konsisten
    val composeBom = platform("androidx.compose:compose-bom:2023.10.01") // Gunakan versi terbaru BOM
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // UI dasar Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Material 3 (dikelola oleh BOM)
    implementation("androidx.compose.material3:material3")

    // Integration dengan activities
    implementation("androidx.activity:activity-compose")

    // Icons extended (opsional, untuk ikon tambahan)
    implementation("androidx.compose.material:material-icons-extended")

    // Animasi (opsional)
    implementation("androidx.compose.animation:animation")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.0")

    // ViewModel (opsional)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}

// Hapus dependensi yang tidak diperlukan jika hanya pakai Compose murni
// implementation(libs.androidx.appcompat)
// implementation(libs.androidx.constraintlayout)
// implementation(libs.material)