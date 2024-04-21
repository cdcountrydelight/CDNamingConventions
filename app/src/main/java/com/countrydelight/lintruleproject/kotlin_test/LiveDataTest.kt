package com.countrydelight.lintruleproject.kotlin_test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveDataTest {

    val wrongMutableLiveDataVariable: MutableLiveData<String> = MutableLiveData()

    val rightMutableLiveData: MutableLiveData<String> = MutableLiveData()

    val wrongLiveDataVariable: LiveData<String> = wrongMutableLiveDataVariable

    val rightLiveData: LiveData<String> = rightMutableLiveData
}