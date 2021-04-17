package com.vhjv0i.planty.ui

import android.content.Context
import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.ui.plants.PlantsPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun plantsPresenter(executor: Executor, plantsInteractor: PlantsInteractor) = PlantsPresenter(executor, plantsInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}