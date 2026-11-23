package com.waqarinstitute.app

import android.app.Application
import com.waqarinstitute.nativecpp.Sentinel

class WciApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Sentinel.nativeInit()
    }
}