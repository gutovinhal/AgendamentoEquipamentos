plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.agendamentoequipamentos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.agendamentoequipamentos"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        // Configuração necessária para o Hilt
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["dagger.hilt.android.internal.disableAndroidSuperclassValidation"] = "true"
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat.v170)
    implementation(libs.material.v1120) // Material design
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.hilt.android)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.ui.graphics.android)

    // Dependências do Compose UI e Material3
    implementation(libs.material3)
    implementation(libs.ui)
    implementation(libs.ui.tooling)
    implementation(libs.androidx.ui.text)
    implementation(libs.androidx.material3.jvmstubs)
    implementation(libs.androidx.material3.android)

    kapt(libs.androidx.room.compiler)
    kapt(libs.hilt.compiler)
    kapt(libs.androidx.lifecycle.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}
