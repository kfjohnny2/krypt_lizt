package com.johnnylee.krypt_lizt.base

import androidx.lifecycle.ViewModel
import com.johnnylee.krypt_lizt.injection.components.DaggerViewModelInjector
import com.johnnylee.krypt_lizt.injection.components.ViewModelInjector
import com.johnnylee.krypt_lizt.injection.modules.NetworkModule
import com.johnnylee.krypt_lizt.ui.main.MainViewModel

open class BaseViewModel : ViewModel(){
    private val injectorApi: ViewModelInjector = DaggerViewModelInjector.factory().create(NetworkModule)

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injectorApi.inject(this)
        }
    }
}