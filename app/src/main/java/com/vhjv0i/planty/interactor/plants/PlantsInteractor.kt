package com.vhjv0i.planty.interactor.plants

import android.util.Log
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
            event.plants = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

}