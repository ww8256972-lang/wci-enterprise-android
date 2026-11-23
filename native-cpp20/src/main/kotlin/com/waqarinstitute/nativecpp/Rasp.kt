package com.waqarinstitute.nativecpp

object Rasp {
    init { System.loadLibrary("wci_sentinel") }
    external fun checkElfIntegrity(): Boolean
    external fun isSelinuxEnforcing(): Boolean
}