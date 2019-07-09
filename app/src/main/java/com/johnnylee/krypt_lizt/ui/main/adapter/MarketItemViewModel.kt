package com.johnnylee.krypt_lizt.ui.main.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.johnnylee.krypt_lizt.base.BaseViewModel
import com.johnnylee.krypt_lizt.model.Market

class MarketItemViewModel :BaseViewModel(){
    private val marketNameLiveData = MutableLiveData<String>()

    fun bind(market: Market) {
        marketNameLiveData.postValue(market.baseSymbol)
    }

    fun getBaseSymbol(): LiveData<String> {
        return marketNameLiveData
    }
}
