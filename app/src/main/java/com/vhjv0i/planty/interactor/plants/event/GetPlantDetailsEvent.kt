package com.vhjv0i.planty.interactor.plants.event

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.SpeciesLight


data class GetPlantDetailsEvent(var code: Int = 0,
                                var plant: Plant? = null,
                                var throwable: Throwable? = null)