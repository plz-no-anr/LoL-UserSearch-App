object Dependencies {

    object Plugins {
        const val APPLICATION = "com.android.application"
        const val LIBRARY = "com.android.library"
        const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
        const val KOTLIN_PARCELIZE = "kotlin-parcelize"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val DAGGER_HILT = "dagger.hilt.android.plugin"

        const val JAVA_LIBRARY = "java-library"
        const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    }

    object ClassPath {
        object Version {
            const val GRADLE_VERSION = "7.4.1"
            const val KOTLIN_VERSION = "1.8.0"
            const val HILT_VERSION = "2.42"
        }

        const val GRADLE = "com.android.tools.build:gradle:${Version.GRADLE_VERSION}"
        const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}"
        const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_VERSION}"
    }

    object AndroidX {

        object Version {
            const val CORE_KTX = "1.7.0"
            const val APP_COMPAT = "1.4.1"
            const val LIFECYCLE = "2.5.0-rc01"
            const val LIFECYCLE_EXTENSION = "2.2.0"
            const val NAVIGATION = "2.5.3"
        }

        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"

        // Lifecycle
        const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE}"
        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE}"
        const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Version.LIFECYCLE_EXTENSION}"

        // Ui
        const val SWIFE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"

        // Splash
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:1.0.0"
    }

    object ThirdParty {

        object Version {
            const val ANDROID_MATERIAL = "1.6.0"
            const val COROUTINES = "1.6.0"
            const val RETROFIT = "2.9.0"
            const val ROOM = "2.5.0"
            const val HILT = "2.42"
            const val GLIDE = "4.14.2"
        }

        // Coroutines
        const val KOTLINX_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINES}"
        const val KOTLINX_COROUTENS_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINES}"

        // Retrofit
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
        const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"

        const val ANDROID_MATERIAL = "com.google.android.material:material:${Version.ANDROID_MATERIAL}"

        // Room
        const val ROOM = "androidx.room:room-ktx:${Version.ROOM}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Version.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"

        // Hilt
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT}"

        // Glide
        const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Version.GLIDE}"

        // Timber
        const val TIMBER = "com.jakewharton.timber:timber:5.0.1"

    }

    object Test {

        object Version {
            const val JUNIT = "4.13.2"
            const val ROBOELETRIC = "4.6.1"
            const val MOCKK = "1.12.4"
            const val OKHTTP3_MOCK_WEBSERVER = "4.9.2"
        }

        const val JUNIT = "junit:junit:${Version.JUNIT}"
        const val ROBOELETRIC = "org.robolectric:robolectric:${Version.ROBOELETRIC}"
        const val MOCKK = "io.mockk:mockk:${Version.MOCKK}"
        const val KOTLIN_COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${ThirdParty.Version.COROUTINES}"
        const val OKHTTP3_MOCK_WEBSERVER = "com.squareup.okhttp3:mockwebserver:${Version.OKHTTP3_MOCK_WEBSERVER}"
    }

    object AndroidTest {

        object Version {
            const val JUNIT = "1.1.3"
            const val ESPRESSO_CORE = "3.4.0"
        }

        const val JUNIT = "androidx.test.ext:junit:${Version.JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
    }

    object MultiModule {
        const val DATA = ":data"
        const val DOMAIN = ":domain"
    }
}