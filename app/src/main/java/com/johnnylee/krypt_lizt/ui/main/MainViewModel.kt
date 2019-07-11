package com.johnnylee.krypt_lizt.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.johnnylee.krypt_lizt.base.BaseViewModel
import com.johnnylee.krypt_lizt.model.Market
import com.johnnylee.krypt_lizt.network.MarketApi
import com.johnnylee.krypt_lizt.ui.main.repository.MainRepository
import com.johnnylee.krypt_lizt.util.helpers.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var marketApi:MarketApi

    private val repository by lazy { MainRepository(marketApi) }

    val marketList = MutableLiveData<List<Market>>().apply { value = mutableListOf() }

    init {
        viewModelScope.launch(Dispatchers.Main) { get() }
    }

    internal suspend fun get() {
        withContext(Dispatchers.IO) {
            val response = repository.getMarkets()
            marketList.postValue(response)

        }
    }

    private fun getMarkets(): List<Market>? {
        return marketList.value
    }
}