package com.vhjv0i.planty

import com.vhjv0i.planty.interactor.InteractorModule
import com.vhjv0i.planty.network.NetworkModule
import com.vhjv0i.planty.ui.UIModule
import com.vhjv0i.planty.ui.about.AboutFragment
import com.vhjv0i.planty.ui.plants.PlantDetailsFragment
import com.vhjv0i.planty.ui.plants.PlantListFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface PlantyApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(plantListFragment: PlantListFragment)
    fun inject(plantDetailsFragment: PlantDetailsFragment)
    fun inject(aboutFragment: AboutFragment)

}