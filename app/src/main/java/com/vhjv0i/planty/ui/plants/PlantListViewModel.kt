package com.vhjv0i.planty.ui.plants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlantListViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is plant list Fragment"
    }
    val text: LiveData<String> = _text
}