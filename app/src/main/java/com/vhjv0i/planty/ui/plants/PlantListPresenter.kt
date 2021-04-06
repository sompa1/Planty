package com.vhjv0i.planty.ui.plants

import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class PlantListPresenter @Inject constructor(private val executor: Executor, private val plantsInteractor: PlantsInteractor) : Presenter<PlantListScreen>(){
}