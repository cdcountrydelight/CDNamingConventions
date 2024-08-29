package com.countrydelight.lintruleproject.kotlin_test.variable_scope_test

class WrongGlobalVariableScopeTest {

    private var wrongGlobalVariableScope = "wrong_scope"

    fun wrongGlobalVariableScope() {
        print(wrongGlobalVariableScope.length)
    }

    //updates the app
    fun updateApp(updateMethod: UpdateTypeEnum) {
        when (updateMethod) {
            UpdateTypeEnum.PLAY_STORE -> TODO()
            UpdateTypeEnum.FIREBASE -> TODO()
            UpdateTypeEnum.ADMIN -> TODO()
        }
    }
}

enum class UpdateTypeEnum { PLAY_STORE, FIREBASE, ADMIN }


