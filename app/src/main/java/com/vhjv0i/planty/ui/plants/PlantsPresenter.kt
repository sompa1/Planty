package com.vhjv0i.planty.ui.plants

import com.vhjv0i.planty.interactor.plants.PlantsInteractor
import com.vhjv0i.planty.interactor.plants.event.GetPlantsEvent
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class PlantsPresenter @Inject constructor(private val executor: Executor, private val plantsInteractor: PlantsInteractor) : Presenter<PlantListScreen>(){
    override fun attachScreen(screen: PlantListScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshPlants(name: String) {
        executor.execute {
            plantsInteractor.getPlants(name)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetPlantsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.plants != null) {
                    screen?.showPlants(event.plants as MutableList<SpeciesLight>)
                }

            }
        }
    }

}