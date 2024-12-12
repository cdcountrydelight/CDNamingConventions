package com.countrydelight.lintruleproject.kotlin_test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class StateVariableTest {

    var wrongStateVariable = mutableStateOf("")

    var rightState = mutableStateOf("")

    var rightByDeligateState by mutableStateOf("")
}