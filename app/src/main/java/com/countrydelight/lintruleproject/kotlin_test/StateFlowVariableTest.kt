package com.countrydelight.lintruleproject.kotlin_test

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateFlowVariableTest {

    val wrongMutableStateFlowVariable = MutableStateFlow(null)

    val rightMutableStateFlow = MutableStateFlow(null)

    val wrongStateFlowVariable = rightMutableStateFlow.asStateFlow()

    val rightStateFlow = rightMutableStateFlow.asStateFlow()
}