@file:Suppress("KDocMissingDocumentation")

object PluginDependencies {
    const val SPOTLESS = "plugins.spotless"
}

object RootDependencies {

    object Versions {
        const val kotlin = "1.3.72"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
}

object AndroidXDependencies {

    object Versions {
        const val appCompat = "1.1.0"
        const val coreKtx = "1.0.2"
        const val lifecycle = "2.0.0"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
}

object NetworkDependencies {

    object Versions {
        const val retrofit = "2.7.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
}

object ViewDependencies {

    object Versions {
        const val materialComponent = "1.1.0-alpha09"
    }

    const val materialComponent =
        "com.google.android.material:material:${Versions.materialComponent}"
}

object TestingDependencies {

    object Versions {
        const val roboelectric = "4.3"
        const val mockito = "2.25.0"
        const val jUnit = "4.12"
        const val androidJUnit = "1.1.1"
        const val androidTest = "1.1.0"
        const val androidTestRunner = "1.1.1"
    }
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val androidTest = "androidx.test:core:${Versions.androidTest}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
}

object ClasspathDependencies {

    object Versions {
        const val gradle = "4.0.0"
        const val spotless = "4.3.0"
    }

    const val allopen = "org.jetbrains.kotlin:kotlin-allopen:${RootDependencies.Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}