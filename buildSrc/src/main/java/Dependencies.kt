object AndroidXCore {
    private const val version = "1.8.0"
    const val core = "androidx.core:core-ktx:$version"
}

object AndroidXAppCompat {
    private const val version = "1.4.2"
    const val appCompat = "androidx.appcompat:appcompat:$version"
}

object Material {
    private const val version = "1.6.1"
    const val material = "com.google.android.material:material:$version"
}

object AndroidXLayout {
    private const val version = "2.1.4"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
}

object AndroidXLifecycle {
    private const val version = "2.4.1"

    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
}

object AndroidXNavigation {
    private const val version = "2.4.2"

    const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
}

object AndroidXFragment {
    private const val version = "1.4.1"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
}

object Coroutine {
    private const val version = "1.6.0"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
}

object DaggerHilt {
    private const val version = "2.40"

    const val core = "com.google.dagger:hilt-core:$version"
    const val android = "com.google.dagger:hilt-android:$version"
    const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
}

object AndroidXHilt {
    const val lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val compiler = "androidx.hilt:hilt-compiler:1.0.0"
}

object Retrofit {
    private const val retrofitVersion = "2.9.0"
    private const val okhttp3Version = "4.9.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val logging = "com.squareup.okhttp3:logging-interceptor:$okhttp3Version"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$okhttp3Version"
}

object Room {
    private const val version = "2.4.2"

    const val roomRuntime = "androidx.room:room-runtime:$version"
    const val roomCompiler = "androidx.room:room-compiler:$version"
    const val roomKtx = "androidx.room:room-ktx:$version"
    const val roomPaging = "androidx.room:room-paging:$version"
}

object DataStore {
    private const val version = "1.0.0"
    const val preferences = "androidx.datastore:datastore-preferences:$version"
}

object Paging3 {
    private const val version = "3.1.1"
    const val paging = "androidx.paging:paging-runtime:$version"
}

object Image {
    private const val version = "4.12.0"

    const val glide = "com.github.bumptech.glide:glide:$version"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
}

object AndroidXJUnit {
    private const val junitVersion = "4.13.2"
    private const val junitExtVersion = "1.1.3"

    const val junit = "junit:junit:$junitVersion"
    const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
}

object EspressoTest {
    private const val version = "3.4.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:$version"
}

object Mockito {
    private const val version = "4.3.1"
    const val mockitoCore = "org.mockito:mockito-core:$version"
    const val mockitoInline = "org.mockito:mockito-inline:$version"
}

object AndroidXTest {
    private const val version = "2.1.0"
    const val coreTest = "androidx.arch.core:core-testing:$version"
}