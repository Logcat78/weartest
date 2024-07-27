package com.jpegviolence.weartest.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    val count =  MutableLiveData<Int>()
    val workStatus = MutableLiveData<Boolean>()
}