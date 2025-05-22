package com.countrydelight.lintruleproject.kotlin_test

class BooleanFunctionNameTest {

    //
    fun isVotingAge(age: Int): Boolean {
        return age >= 18
    }

    //
    fun wrongVotingAge(age: Int): Boolean {
        return age >= 18
    }


    var whetherPackagerHasScanned: Boolean
        get() {
            return true
        }
        set(value) {

        }

}