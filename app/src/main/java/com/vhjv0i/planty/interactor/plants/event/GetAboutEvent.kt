package com.vhjv0i.planty.interactor.plants.event

import com.vhjv0i.planty.model.Plant
import com.vhjv0i.planty.model.SpeciesLight


data class GetAboutEvent(var code: Int = 0,
                         var throwable: Throwable? = null)