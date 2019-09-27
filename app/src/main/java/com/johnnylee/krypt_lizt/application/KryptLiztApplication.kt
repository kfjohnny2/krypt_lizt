package com.johnnylee.krypt_lizt.application

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.johnnylee.krypt_lizt.injection.modules.networkModule
import org.koin.android.ext.android.startKoin

class KryptLiztApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule))
        appContext = applicationContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}