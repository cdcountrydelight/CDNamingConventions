package com.countrydelight.lintruleproject.kotlin_test.variable_scope

class RightGlobalVariableScope {

    private var rightGlobalVariableScope = "right_scope"

    fun rightGlobalVariableScope1() {
        print(rightGlobalVariableScope.length)
    }

    fun rightGlobalVariableScope2() {
        print(rightGlobalVariableScope.length)
    }
}