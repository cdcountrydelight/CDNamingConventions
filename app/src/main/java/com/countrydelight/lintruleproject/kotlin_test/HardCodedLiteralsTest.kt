package com.countrydelight.lintruleproject.kotlin_test

import kotlin.random.Random

class HardCodedLiteralsTest {

    // comment
    fun hardCodedNumberTest() {
        var a = 100
        a = getA()
        val res = a == 100
        if (a == 100) {

        }
    }

    // comment
    private fun getA(): Int {
        return Random(100).nextInt()
    }
}