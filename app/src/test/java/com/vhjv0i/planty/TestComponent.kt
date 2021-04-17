package com.vhjv0i.planty

import com.vhjv0i.planty.interactor.InteractorModule
import com.vhjv0i.planty.mock.MockNetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : PlantyApplicationComponent {

}