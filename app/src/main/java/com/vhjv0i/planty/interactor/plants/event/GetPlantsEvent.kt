package com.vhjv0i.planty.interactor.plants.event

import io.swagger.client.models.SpeciesLight

data class GetPlantsEvent(var code: Int = 0,
                          var plants: List<SpeciesLight>? = null,
                          var throwable: Throwable? = null)