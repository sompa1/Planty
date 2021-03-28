package com.vhjv0i.planty

import android.app.Activity
import androidx.fragment.app.Fragment


val Activity.injector: PlantyApplicationComponent
    get() {
        return (this.applicationContext as PlantyApplication).injector
    }

val Fragment.injector: PlantyApplicationComponent
    get() {
        return (this.requireContext().applicationContext as PlantyApplication).injector
    }