package com.vhjv0i.planty

import android.content.Context
import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.ui.plants.PlantsPresenter
import com.vhjv0i.planty.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideArtistsPresenter(executor: Executor, plantsInteractor: PlantsInteractor) = PlantsPresenter(executor, plantsInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}