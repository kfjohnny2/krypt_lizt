package com.johnnylee.krypt_lizt.injection.modules

import com.google.gson.GsonBuilder
import com.johnnylee.krypt_lizt.BuildConfig
import com.johnnylee.krypt_lizt.BuildConfig.API_URL
import com.johnnylee.krypt_lizt.network.MarketApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


// This module tells a Component which are its subcomponents
// Install this module in Hilt-generated ViewModelInjector
@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    /**
     * Provides the MarketApi service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the MarketApi service implementation.
     */
    @Provides
    @Reusable
    internal fun provideMarketApi(retrofit: Retrofit): MarketApi {
        return retrofit.create(MarketApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    internal fun provideRetrofitInterface(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
//        val header =
//            Interceptor { it.proceed(it.request().newBuilder().addHeader("Authorization", getAccessToken()!!).build()) }
        val httpClient = OkHttpClient.Builder()

        httpClient.readTimeout(230, TimeUnit.SECONDS)
        httpClient.connectTimeout(230, TimeUnit.SECONDS)

        //INTERCEPTORS
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(logging)
        }

//        httpClient.addInterceptor(header)

//        val tokenApi =
//            retrofit2.Retrofit.Builder().baseUrl(IDENTITY_URL).addConverterFactory(GsonConverterFactory.create(gson))
//                .client(httpClient.build()).build().create(TokenApi::class.java)
//
//        httpClient.authenticator(TokenAuthenticator(tokenApi))

        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}