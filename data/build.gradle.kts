plugins {
    id(Dependencies.Plugins.LIBRARY)
    id(Dependencies.Plugins.KOTLIN_ANDROID)
    id(Dependencies.Plugins.KOTLIN_PARCELIZE)
    id(Dependencies.Plugins.KOTLIN_KAPT)
    id(Dependencies.Plugins.DAGGER_HILT)
}

android {
    namespace= AppConfig.APPLICATION_ID
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = AppConfig.ANDROID_TEST_INSTRUMENTATION
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
        sourceCompatibility = AppConfig.JAVA_COMPATIBILITY
        targetCompatibility = AppConfig.JAVA_COMPATIBILITY
    }
    kotlinOptions {
        jvmTarget = AppConfig.JAVA_JVM_TARGET
    }
}

dependencies {
    implementation(project(Dependencies.MultiModule.DOMAIN))

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTINES_CORE)
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTENS_ANDROID)

    // Coroutines
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTINES_CORE)
    implementation(Dependencies.ThirdParty.KOTLINX_COROUTENS_ANDROID)
    // Retrofit
    implementation(Dependencies.ThirdParty.RETROFIT)
    implementation(Dependencies.ThirdParty.RETROFIT_CONVERTER_GSON)

    implementation(Dependencies.ThirdParty.ANDROID_MATERIAL)

    // Room
    implementation(Dependencies.ThirdParty.ROOM)
    implementation(Dependencies.ThirdParty.ROOM_RUNTIME)
    implementation(Dependencies.ThirdParty.ROOM_COMPILER)
    // Hilt
    implementation(Dependencies.ThirdParty.HILT_ANDROID)
    implementation(Dependencies.ThirdParty.HILT_ANDROID_COMPILER)

    // Glide
    implementation(Dependencies.ThirdParty.GLIDE)
    implementation(Dependencies.ThirdParty.GLIDE_COMPILER)

    // Test
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.ROBOELETRIC)
}