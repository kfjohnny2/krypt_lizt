package com.johnnylee.krypt_lizt.ui.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import com.johnnylee.krypt_lizt.base.BaseViewModel
import com.johnnylee.krypt_lizt.network.MarketApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel(){
    @Inject
    lateinit var marketApi: MarketApi

    init {
        viewModelScope.launch (Dispatchers.Main){ get() }
    }

    internal suspend fun get(){
        withContext(Dispatchers.IO){
            val items = marketApi.getMarkets()
            Log.d("Items", items.toString())
        }
    }
}