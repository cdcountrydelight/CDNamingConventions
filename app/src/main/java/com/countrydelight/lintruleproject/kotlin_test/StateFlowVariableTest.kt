package com.countrydelight.lintruleproject.kotlin_test

import kotlinx.coroutines.flow.MutableStateFlow

class StateFlowVariableTest {
    val wrongStateFlowVariable = MutableStateFlow(null)
    val rightStateFlow = MutableStateFlow(null)
}