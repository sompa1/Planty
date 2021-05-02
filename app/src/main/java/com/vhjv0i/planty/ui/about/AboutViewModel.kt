package com.vhjv0i.planty.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Somló Panna, VHJV0I"
    }
    val text: LiveData<String> = _text
}