package com.vhjv0i.planty.ui.plants

import io.swagger.client.models.SpeciesLight

interface PlantListScreen {
    fun showPlants(plants: List<SpeciesLight>?)
    fun showNetworkError(errorMsg: String)
}