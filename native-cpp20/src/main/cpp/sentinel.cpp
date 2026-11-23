#include <jni.h>
#include <android/log.h>
#include <unistd.h>
#include <sys/prctl.h>
#include <sys/resource.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <thread>
#include <atomic>

#define LOG_TAG "WCI_SENTINEL"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

static std::atomic<bool> g_raspRunning{false};

extern "C" JNIEXPORT jboolean JNICALL
Java_com_waqarinstitute_nativecpp_Sentinel_nativeInit(JNIEnv* env, jclass clazz) {
    // RLIMIT_AS guard
    struct rlimit rl;
    rl.rlim_cur = 512 * 1024 * 1024;
    rl.rlim_max = 512 * 1024 * 1024;
    setrlimit(RLIMIT_AS, &rl);
    // prctl no new privs
    prctl(PR_SET_NO_NEW_PRIVS, 1, 0, 0, 0);
    LOGI("Sentinel initialized");
    return JNI_TRUE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_waqarinstitute_nativecpp_Sentinel_isFridaDetected(JNIEnv* env, jclass clazz) {
    // TracerPid check
    FILE* f = fopen("/proc/self/status", "r");
    if (!f) return JNI_FALSE;
    char line[256];
    while (fgets(line, sizeof(line), f)) {
        if (strncmp(line, "TracerPid:", 10) == 0) {
            int pid = atoi(line + 10);
            fclose(f);
            return (pid != 0) ? JNI_TRUE : JNI_FALSE;
        }
    }
    fclose(f);
    return JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_com_waqarinstitute_nativecpp_Sentinel_zeroize(JNIEnv* env, jclass clazz, jbyteArray arr) {
    jsize len = env->GetArrayLength(arr);
    jbyte* ptr = env->GetByteArrayElements(arr, nullptr);
    if (ptr) {
        memset_s(ptr, len, 0, len);
        env->ReleaseByteArrayElements(arr, ptr, 0);
    }
}