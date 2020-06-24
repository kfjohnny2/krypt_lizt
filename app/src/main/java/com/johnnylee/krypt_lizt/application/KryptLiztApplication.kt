package com.johnnylee.krypt_lizt.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.johnnylee.krypt_lizt.injection.components.ViewModelInjector
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KryptLiztApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}