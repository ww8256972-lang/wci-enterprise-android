plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}
android {
    namespace = "com.waqarinstitute.exam"
    compileSdk = 35
    defaultConfig { minSdk = 26 }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation(project(":core-crypto"))
    implementation(project(":native-cpp20"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.coroutines.android)
    implementation(libs.mlkit.face.detection)
}