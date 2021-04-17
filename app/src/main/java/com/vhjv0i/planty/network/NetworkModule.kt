package com.vhjv0i.planty.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder? {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun providePlantsApi(retrofitBuilder: Retrofit.Builder): PlantsApi? {
        return retrofitBuilder.baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS).addConverterFactory(GsonConverterFactory.create()).build()
            .create(PlantsApi::class.java)
    }
}