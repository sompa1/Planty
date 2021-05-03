package com.vhjv0i.planty.mock

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.PlantBase
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.model.SpeciesLightBase
import com.vhjv0i.planty.network.PlantsApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockPlantsApi: PlantsApi {

    override fun getPlants(apiKey: String, commonName: String): Call<SpeciesLightBase> {

        val plantList = ArrayList<SpeciesLight>()
        val plantItem = SpeciesLight(1, "Evergreen oak", "quercus-rotundifolia", "Quercus rotundifolia",
            1785, "Encycl. 1: 723 (1785)", "Lam.", SpeciesLight.Status.ACCEPTED, SpeciesLight.Rank.SPECIES, "Beech family", "Quercus",1, "Quercus","https://bs.plantnet.org/image/o/1a03948baf0300da25558c2448f086d39b41ca30")

        plantList.add(plantItem)
        val speciesLightBase = SpeciesLightBase(plantList)

        val call = object : Call<SpeciesLightBase> {
            @Throws(IOException::class)
            override fun execute(): Response<SpeciesLightBase> {
                return Response.success(speciesLightBase)
            }

            override fun enqueue(callback: Callback<SpeciesLightBase>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<SpeciesLightBase> {
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

    override fun getPlantDetails(apiKey: String, id: String): Call<PlantBase> {
        val plant = Plant(1,"Evergreen oak", "quercus-rotundifolia", "Quercus rotundifolia",
            "https://bs.plantnet.org/image/o/1a03948baf0300da25558c2448f086d39b41ca30", 1785, "Encycl. 1: 723 (1785)", "Lam.", "Beech family", 1, 1, false, "SW. Europe, N. Africa")

        val plantBase = PlantBase(plant)

        val call = object : Call<PlantBase> {
            @Throws(IOException::class)
            override fun execute(): Response<PlantBase> {
                return Response.success(plantBase)
            }

            override fun enqueue(callback: Callback<PlantBase>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<PlantBase> {
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

}