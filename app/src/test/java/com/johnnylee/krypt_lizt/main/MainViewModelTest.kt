package com.johnnylee.krypt_lizt.main

import com.johnnylee.krypt_lizt.model.Market
import com.johnnylee.krypt_lizt.ui.main.MainViewModel
import com.johnnylee.krypt_lizt.ui.main.repository.MainRepository
import com.johnnylee.krypt_lizt.util.helpers.CoroutineContextProvider
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest{

    @Mock
    private lateinit var mockRepository: MainRepository

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel()

    }

    @Test
    fun showDataFromApi() = runBlocking{
        val expectedResult = mutableListOf<Market>()
        Mockito.`when`(mockRepository.getMarkets()).thenReturn(expectedResult)

        mainViewModel.get()

        Mockito.verify(mainViewModel).marketList.value = expectedResult
    }
}