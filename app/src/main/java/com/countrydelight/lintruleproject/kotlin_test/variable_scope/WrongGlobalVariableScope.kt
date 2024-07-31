package com.countrydelight.lintruleproject.kotlin_test.variable_scope

class WrongGlobalVariableScope {

    private var wrongGlobalVariableScope = "wrong_scope"

    fun wrongGlobalVariableScope() {
        print(wrongGlobalVariableScope.length)
    }
}