package com.johnnylee.krypt_lizt.injection.components

import android.content.Context
import com.johnnylee.krypt_lizt.injection.modules.NetworkModule
import com.johnnylee.krypt_lizt.ui.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for ViewModels.
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified MainViewModel.
     * @param mainViewModel MainViewModel in which to inject the dependencies
     */
    fun inject(mainViewModel: MainViewModel)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance networkModule: NetworkModule): ViewModelInjector
    }
}