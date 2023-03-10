plugins {
    id(Dependencies.Plugins.APPLICATION)
    id(Dependencies.Plugins.KOTLIN_ANDROID)
    id(Dependencies.Plugins.KOTLIN_PARCELIZE)
    kotlin(Dependencies.Plugins.KOTLIN_KAPT)
    id(Dependencies.Plugins.DAGGER_HILT)
}

android {
    namespace = AppConfig.APPLICATION_ID
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.ANDROID_TEST_INSTRUMENTATION
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.JAVA_COMPATIBILITY
        targetCompatibility = AppConfig.JAVA_COMPATIBILITY
    }
    kotlinOptions {
        jvmTarget = AppConfig.JAVA_JVM_TARGET
    }
    testOptions {
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(Dependencies.MultiModule.DATA))
    implementation(project(Dependencies.MultiModule.DOMAIN))

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)

    // Splash
    implementation(Dependencies.AndroidX.SPLASH_SCREEN)

    // UI
    implementation(Dependencies.ThirdParty.ANDROID_MATERIAL)
    implementation(Dependencies.AndroidX.SWIFE_REFRESH_LAYOUT)
    implementation(Dependencies.AndroidX.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.NAVIGATION_UI_KTX)

    // Lifecycle
    implementation(Dependencies.AndroidX.LIFECYCLE_LIVEDATA_KTX)
    implementation(Dependencies.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Dependencies.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.AndroidX.LIFECYCLE_EXTENSIONS)

    // Coroutines
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTINES_CORE)
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTENS_ANDROID)

    // Retrofit
    implementation(Dependencies.ThirdParty.RETROFIT)
    implementation(Dependencies.ThirdParty.RETROFIT_CONVERTER_GSON)

    // Room
    implementation(Dependencies.ThirdParty.ROOM)
    implementation(Dependencies.ThirdParty.ROOM_RUNTIME)
    kapt(Dependencies.ThirdParty.ROOM_COMPILER)

    // Hilt
    implementation(Dependencies.ThirdParty.HILT_ANDROID)
    kapt(Dependencies.ThirdParty.HILT_ANDROID_COMPILER)

    // Glide
    implementation(Dependencies.ThirdParty.GLIDE)
    kapt(Dependencies.ThirdParty.GLIDE_COMPILER)

    // Epoxy
    implementation(Dependencies.ThirdParty.EPOXY)
    implementation(Dependencies.ThirdParty.EPOXY_DATABINDING)
    kapt(Dependencies.ThirdParty.EPOXY_PROCESSOR)

    // Timber
    implementation(Dependencies.ThirdParty.TIMBER)

    // Test
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.ROBOELETRIC)

    // Android Test
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)

}