package com.vhjv0i.planty.ui.plants

import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.interactor.plants.event.GetPlantDetailsEvent
import com.vhjv0i.planty.interactor.plants.event.GetPlantsEvent
import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class PlantDetailsPresenter @Inject constructor(private val executor: Executor, private val plantsInteractor: PlantsInteractor) : Presenter<PlantDetailsScreen>(){
    override fun attachScreen(screen: PlantDetailsScreen) {
        super.attachScreen(screen)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun getPlantById(id: String) {
        executor.execute {
            plantsInteractor.getPlantDetails(id)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetPlantDetailsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.plant != null) {
                    screen?.showPlantDetails(event.plant as Plant)
                }

            }
        }
    }

}