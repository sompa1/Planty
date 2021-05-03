package com.vhjv0i.planty.ui.plants

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.SpeciesLight


interface PlantDetailsScreen {
    fun showPlantDetails(plant: Plant?)
    fun showNetworkError(errorMsg: String)
}