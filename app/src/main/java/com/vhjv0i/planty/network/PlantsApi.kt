package com.vhjv0i.planty.network

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.PlantBase
import com.vhjv0i.planty.model.SpeciesLight
import com.vhjv0i.planty.model.SpeciesLightBase
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PlantsApi {
    @GET("plants")
    fun getPlants(
        @Query("token") apiKey: String,
        @Query("common_name") commonName: String): Call<SpeciesLightBase>

    @GET("plants/{id}")
    fun getPlantDetails(
            @Path("id") id : String,
            @Query("token") apiKey: String): Call<PlantBase>
}