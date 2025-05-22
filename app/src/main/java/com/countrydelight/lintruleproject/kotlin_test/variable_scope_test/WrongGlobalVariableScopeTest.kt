package com.countrydelight.lintruleproject.kotlin_test.variable_scope_test

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class WrongGlobalVariableScopeTest @Inject constructor(private val hello: String) {

    private val hiThereStateFlow: StateFlow<String> = MutableStateFlow("")

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

    fun hi() {
    }
}

enum class UpdateTypeEnum { PLAY_STORE, FIREBASE, ADMIN }


