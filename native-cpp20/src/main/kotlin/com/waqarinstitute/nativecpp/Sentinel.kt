package com.waqarinstitute.nativecpp

object Sentinel {
    init { System.loadLibrary("wci_sentinel") }
    external fun nativeInit(): Boolean
    external fun isFridaDetected(): Boolean
    external fun zeroize(arr: ByteArray)
}