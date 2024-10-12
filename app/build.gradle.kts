import java.util.Properties

val properties: Properties = Properties()

properties.load(
    project.rootProject
        .file("local.properties")
        .inputStream()
)

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //   added
    alias(libs.plugins.android.dagger.hilt)
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest"
    compileSdk = 34

    defaultConfig {
        applicationId = "cl.rodrigo_javier_garrido_dagle.mobiledevtest"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = false
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
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/licenses/**"
            excludes += "META-INF/AL2.0"
            excludes += "META-INF/LGPL2.1"
        }
    }

    flavorDimensions += "version"
    productFlavors {

        create("ApplyDigital") {
            applicationIdSuffix = ".ApplyDigital"
            versionNameSuffix = "1_ApplyDigital"

            resValue(
                "string",
                "app_name",
                "Rodrigo Javier test"
            )

            buildConfigField(
                "String",
                "URL_BASE",
                properties.getProperty("URL_BASE")
            )

            buildConfigField(
                "String",
                "URL_ENDPOINT",
                properties.getProperty("URL_ENDPOINT")
            )

        }

    }

// **********************************************
    sourceSets {
//        this.getByName("androidTest") {
//            resources.srcDirs("src/androidTest/resources", "src/sharedTest/resources")
//        }
        this.getByName("test") {
            resources.srcDirs("src/test/java/cl/rodrigo_javier_garrido_dagle/mobiledevtest")
        }
    }
// **********************************************

//    testOptions {
//        unitTests.isReturnDefaultValues = true
//    }
// app/src/test/java/cl/rodrigo_javier_garrido_dagle/mobiledevtest/domain/usecases/HitUsecasesTest.kt
// app/src/main/java/cl/rodrigo_javier_garrido_dagle/mobiledevtest/domain/usecases/HitUsecases.kt

// **********************************************
    hilt {
        enableAggregatingTask = true
    }
// **********************************************

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // TESTS ADDED
    testImplementation(libs.mokk)
    testImplementation(libs.mockitocore)
    testImplementation(libs.mockitoinline)
//   picasso
    implementation(libs.androidx.picasso)
    //    retrofit
    implementation(libs.androidx.retrofit)
    implementation(libs.androidx.retrofitgson)
// okhttp
    implementation(libs.okhttp)
    implementation(libs.googlegson)
    implementation(libs.okhttp.interceptor)
    //    coroutines
    implementation(libs.androidx.coroutines)
    implementation(libs.androidx.coroutinesandroid)
    //   coroutine lifecycle scopes
    implementation(libs.androidx.activityktx)
    implementation(libs.androidx.lifecyclesextensions)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // KTX - Viewmodel Y Livedata NO ACTUALIZAR: 2.5.1
    implementation(libs.androidx.lifecycle.livedata)
    //    data store
    implementation(libs.androidx.datastore)
    //Room
    implementation(libs.room)
    kapt(libs.roomkaptcompiler)
    implementation(libs.androidx.room.runtime)
    //Hilt
    implementation(libs.dagger.google)
    implementation(libs.androidx.hilt.navigation.compose.v120)
    annotationProcessor(libs.androidx.google.compiler)
    kapt(libs.androidx.google.dagger.kapt.android)
    kapt(libs.androidx.google.compiler)
    kapt(libs.androidx.hilt.compiler.v120)
    //navigation
    implementation(libs.androidx.navigation.compose)
    //
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.accompanist.swiperefresh)
    //
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}

kapt { correctErrorTypes = true }