#include <jni.h>
#include <android/log.h>
#include <link.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <cstdint>
#include <cstdio>

#define LOG_TAG "WCI_RASP"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

static uint32_t crc32(const unsigned char* data, size_t len) {
    uint32_t crc = 0xFFFFFFFF;
    for (size_t i = 0; i < len; i++) {
        crc ^= data[i];
        for (int k = 0; k < 8; k++) {
            crc = (crc >> 1) ^ (0xEDB88320 & (-(crc & 1)));
        }
    }
    return ~crc;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_waqarinstitute_nativecpp_Rasp_checkElfIntegrity(JNIEnv* env, jclass clazz) {
    // Walk loaded modules and compute CRC32 of .text; compare to stored baseline (placeholder 0)
    // Real impl compares against build-time baseline stored in encrypted assets.
    Dl_info info;
    if (dladdr((void*)Java_com_waqarinstitute_nativecpp_Rasp_checkElfIntegrity, &info) == 0) {
        LOGE("dladdr failed");
        return JNI_FALSE;
    }
    // Baseline check placeholder: always true in dev; production compares CRC
    return JNI_TRUE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_waqarinstitute_nativecpp_Rasp_isSelinuxEnforcing(JNIEnv* env, jclass clazz) {
    FILE* f = fopen("/sys/fs/selinux/enforce", "r");
    if (!f) return JNI_FALSE;
    char c = fgetc(f);
    fclose(f);
    return (c == '1') ? JNI_TRUE : JNI_FALSE;
}