plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "br.senai.sp.jandira.loginsynbian"
    compileSdk = 33

    defaultConfig {
        applicationId = "br.senai.sp.jandira.loginsynbian"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.google.firebase:firebase-firestore:24.9.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")




    //Retrofit dependencies

    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    // para usar o calendario

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")

    //Google Services
    implementation ("com.google.android.gms:play-services-auth:20.4.1")


    // Firebase Service

    implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
    implementation ("androidx.compose.material3:material3:x.y.z")

    //coil
    implementation ("io.coil-kt:coil-compose:2.3.0")
    implementation ("androidx.activity:activity-compose:1.3.1")

    implementation ("com.google.android.gms:play-services-location:18.0.0")

    implementation ("androidx.compose.material3:material3:1.0.0-beta01")

    //exoplayer
    implementation ("com.google.android.exoplayer:exoplayer:2.19.1")

    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.28")


    // Fontes do Google
    implementation ("androidx.compose.ui:ui-text-google-fonts:1.4.3")
    //Mais icones

    implementation ("androidx.compose.material:material-icons-extended:1.2.0")



    //Mais icones
    implementation ("androidx.compose.material:material-icons-extended:1.2.0")


    implementation ("com.squareup.picasso:picasso:2.8")
    implementation("androidx.navigation:navigation-compose:2.6.0")


}