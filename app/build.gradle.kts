plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    compileSdk = AndroidConfig.compileSdkVersion

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdkVersion
        targetSdk = AndroidConfig.targetSdkVersion
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.testRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
}

dependencies {

    implementation(AndroidXCore.core)
    implementation(AndroidXAppCompat.appCompat)
    implementation(Material.material)
    implementation(AndroidXLayout.constraintLayout)

    implementation(AndroidXLifecycle.liveDataKtx)
    implementation(AndroidXLifecycle.viewModelKtx)
    implementation(AndroidXNavigation.fragmentKtx)
    implementation(AndroidXNavigation.uiKtx)
    implementation(AndroidXFragment.fragmentKtx)
    implementation(Coroutine.coroutineCore)

    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)
    kapt(DaggerHilt.androidCompiler)
    implementation(AndroidXHilt.lifecycle)
    kapt(AndroidXHilt.compiler)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.moshi)
    implementation(Retrofit.logging)

    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    implementation(Room.roomPaging)

    implementation(DataStore.preferences)

    implementation(Paging3.paging)

    implementation(Image.glide)
    kapt(Image.glideCompiler)

    testImplementation(AndroidXJUnit.junit)
    androidTestImplementation(AndroidXJUnit.junitExt)
    androidTestImplementation(EspressoTest.espressoCore)
}