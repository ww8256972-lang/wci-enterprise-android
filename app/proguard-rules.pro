# Keep JNI
-keepclasseswithmembernames class * {
    native <methods>;
}
-keep class com.waqarinstitute.nativecpp.** { *; }
-keep class com.waqarinstitute.crypto.** { *; }
# Keep data classes / serialization
-keepattributes *Annotation*
-keep class kotlinx.** { *; }
-dontwarn org.conscrypt.**