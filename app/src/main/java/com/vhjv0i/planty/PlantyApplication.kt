package com.vhjv0i.planty

import android.app.Application
import com.vhjv0i.planty.ui.UIModule

class PlantyApplication : Application() {

    lateinit var injector: PlantyApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerPlantyApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

}