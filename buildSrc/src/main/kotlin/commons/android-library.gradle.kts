package commons

import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("plugin.allopen")
    kotlin("kapt")
}

android {
    compileSdkVersion(BuildConfiguration.compileSdkVersion)

    defaultConfig {
        minSdkVersion(BuildConfiguration.minSdkVersion)
        targetSdkVersion(BuildConfiguration.targetSdkVersion)

        buildToolsVersion(BuildConfiguration.buildToolsVersion)

        versionCode = BuildConfiguration.versionCode
        versionName = BuildConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    androidExtensions {
        isExperimental = true
    }

    lintOptions {
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(RootDependencies.kotlin)
}
