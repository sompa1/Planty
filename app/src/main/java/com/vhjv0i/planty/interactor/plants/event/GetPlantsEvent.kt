package com.vhjv0i.planty.interactor.plants.event

import com.vhjv0i.planty.model.SpeciesLight


data class GetPlantsEvent(var code: Int = 0,
                          var plants: List<SpeciesLight>? = null,
                          var throwable: Throwable? = null)