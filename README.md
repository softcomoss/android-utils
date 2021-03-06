# Android Utility

General utility functions that are used by Android Developers

## Installation

### Method 1 - AAR Package
- Clone the repository
- Run `./gradlew assembleRelease`
- Get the library archive at ***./utils/build/outputs/aar/utils-release.aar***
- Import the library into your project

### Method 2 - Gradle Dependency
- Add the jitpack repository to your root `build.gradle`
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Add the dependency to your module
```gradle
dependencies {
    implementation 'com.github.softcomoss:android-utils:0.1.0'
}
```

## Contributing

See [CONTRIBUTING.md](https://github.com/softcomoss/android-utils/blob/master/CONTRIBUTING.md) for contributing guidelines

## TODO

- Add more utility functions
- Upload to jCenter.
