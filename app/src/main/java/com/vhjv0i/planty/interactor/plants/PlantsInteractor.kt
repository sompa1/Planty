package com.vhjv0i.planty.interactor.plants

import android.util.Log
import com.vhjv0i.planty.interactor.plants.event.GetAboutEvent
import com.vhjv0i.planty.interactor.plants.event.GetPlantDetailsEvent
import com.vhjv0i.planty.interactor.plants.event.GetPlantsEvent
import com.vhjv0i.planty.network.PlantsApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class PlantsInteractor @Inject constructor(private var plantsApi: PlantsApi) {
    fun getPlants(name: String) {
        val event = GetPlantsEvent()

        try {

            val plantsQueryCall = plantsApi.getPlants("w13pBqSMuB6hYsXmOhlty-Ctb_olDiHchWFLkg3AdeA", name)

            val response = plantsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.plants = response.body()?.data
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getPlantDetails(id: String) {
        val event = GetPlantDetailsEvent()

        try {

            val plantsQueryCall = plantsApi.getPlantDetails(id,"w13pBqSMuB6hYsXmOhlty-Ctb_olDiHchWFLkg3AdeA")

            val response = plantsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.plant = response.body()?.data
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getAbout(id: String) {
        val event = GetAboutEvent()

        try {
            event.code = 1
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

}