package com.vhjv0i.planty.mock

import com.vhjv0i.planty.network.PlantsApi
import dagger.Provides
import javax.inject.Singleton

class MockNetworkModule {

    @Provides
    @Singleton
    fun provideArtistsApi(): PlantsApi = MockPlantsApi()
}