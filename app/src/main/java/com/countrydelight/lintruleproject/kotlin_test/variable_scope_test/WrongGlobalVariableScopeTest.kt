package com.countrydelight.lintruleproject.kotlin_test.variable_scope_test

class WrongGlobalVariableScopeTest {

    private var wrongGlobalVariableScope = "wrong_scope"

    fun wrongGlobalVariableScope() {
        print(wrongGlobalVariableScope.length)
    }
}