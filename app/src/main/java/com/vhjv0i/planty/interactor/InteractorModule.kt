package com.vhjv0i.planty.interactor

import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.network.PlantsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun providePlantsInteractor(plantsApi: PlantsApi) = PlantsInteractor(plantsApi)
}