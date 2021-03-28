package com.vhjv0i.planty

import android.app.Application

class PlantyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        var injector: PlantyApplicationComponent? = null
    }
}