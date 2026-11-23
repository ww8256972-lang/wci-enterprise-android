package com.waqarinstitute.nativecpp

object Seccomp {
    init { System.loadLibrary("wci_sentinel") }
    external fun installSandbox(): Boolean
}