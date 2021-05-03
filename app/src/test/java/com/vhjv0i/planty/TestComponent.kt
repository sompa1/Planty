package com.vhjv0i.planty

import com.vhjv0i.planty.interactor.InteractorModule
import com.vhjv0i.planty.mock.MockNetworkModule
import com.vhjv0i.planty.test.PlantDetailsTest
import com.vhjv0i.planty.test.PlantsTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : PlantyApplicationComponent {
    fun inject(plantDetailsTest: PlantDetailsTest)
    fun inject(plantsTest: PlantsTest)

}