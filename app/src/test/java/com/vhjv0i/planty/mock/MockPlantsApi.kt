package com.vhjv0i.planty.mock

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.network.PlantsApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockPlantsApi: PlantsApi {

    override fun getPlants(apiKey: String, commonName: String): Call<List<SpeciesLight>> {
        val plantList = ArrayList<SpeciesLight>()



        val plantItem = SpeciesLight(1, "Evergreen oak", "quercus-rotundifolia", "Quercus rotundifolia",
            1785, "Encycl. 1: 723 (1785)", "Lam.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Beech family", "https://bs.plantnet.org/image/o/1a03948baf0300da25558c2448f086d39b41ca30", 1, "Quercus")

        plantList.add(plantItem)

        val call = object : Call<List<SpeciesLight>> {
            @Throws(IOException::class)
            override fun execute(): Response<List<SpeciesLight>> {
                return Response.success(plantList)
            }

            override fun enqueue(callback: Callback<List<SpeciesLight>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<SpeciesLight>> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }
        }

        return call
    }

    override fun getPlantDetails(apiKey: String, id: String): Call<Plant> {
        TODO("Not yet implemented")
    }

}