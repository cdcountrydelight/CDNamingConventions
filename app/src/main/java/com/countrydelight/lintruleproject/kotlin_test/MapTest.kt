package com.countrydelight.lintruleproject.kotlin_test

class MapTest {

    val wrongMutableMapVariable = mutableMapOf<String, String>()

    val rightMutableMap = mutableMapOf<String, String>()

    val wrongHashMapVariable = hashMapOf<String, String>()

    val rightHashMap = hashMapOf<String, String>()

    val hashMap: MutableMap<String, String>? = null


    //test
    fun testMap(): MutableMap<String, String> {
        return hashMap ?: mutableMapOf()
    }

}