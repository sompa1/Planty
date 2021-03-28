package com.vhjv0i.planty

import com.vhjv0i.planty.network.NetworkModule
import com.vhjv0i.planty.ui.UIModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, NetworkModule::class])
interface PlantyApplicationComponent {
    fun inject(mainActivity: MainActivity?)
}