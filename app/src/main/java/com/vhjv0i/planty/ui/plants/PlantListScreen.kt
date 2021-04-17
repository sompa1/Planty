package com.vhjv0i.planty.ui.plants

import com.vhjv0i.planty.model.SpeciesLight


interface PlantListScreen {
    fun showPlants(plants: List<SpeciesLight>?)
    fun showNetworkError(errorMsg: String)
}