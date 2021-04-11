package com.vhjv0i.planty.network

import io.swagger.client.models.Plant
import io.swagger.client.models.SpeciesLight
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PlantsApi {
    @GET("plants")
    fun getPlants(
            @Header("x-api-key") apiKey: String,
            @Query("common_name") commonName: String): Call<List<SpeciesLight>>

    @GET("plants/{id}")
    fun getPlantDetails(
            @Header("x-api-key") apiKey: String,
            @Path("id") id : String): Call<Plant>
}