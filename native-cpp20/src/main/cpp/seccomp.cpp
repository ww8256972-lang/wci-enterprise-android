#include <jni.h>
#include <sys/prctl.h>
#include <linux/seccomp.h>
#include <linux/filter.h>
#include <sys/syscall.h>
#include <unistd.h>
#include <android/log.h>

#define LOG_TAG "WCI_SECCOMP"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT jboolean JNICALL
Java_com_waqarinstitute_nativecpp_Seccomp_installSandbox(JNIEnv* env, jclass clazz) {
    if (prctl(PR_SET_NO_NEW_PRIVS, 1, 0, 0, 0) != 0) {
        return JNI_FALSE;
    }
    // Minimal seccomp filter: allow read/write/exit; block others (illustrative)
    struct sock_filter filter[] = {
        BPF_STMT(BPF_LD | BPF_W | BPF_ABS, offsetof(struct seccomp_data, nr)),
        BPF_JUMP(BPF_JMP | BPF_JEQ | BPF_K, __NR_read, 1, 0),
        BPF_JUMP(BPF_JMP | BPF_JEQ | BPF_K, __NR_write, 1, 0),
        BPF_STMT(BPF_RET | BPF_K, SECCOMP_RET_ALLOW),
        BPF_STMT(BPF_RET | BPF_K, SECCOMP_RET_TRAP),
    };
    struct sock_fprog prog = { .len = (unsigned short)(sizeof(filter)/sizeof(filter[0])), .filter = filter };
    if (syscall(__NR_seccomp, SECCOMP_SET_MODE_FILTER, 0, &prog) != 0) {
        LOGI("seccomp filter not installed (may be unsupported)");
    }
    return JNI_TRUE;
}