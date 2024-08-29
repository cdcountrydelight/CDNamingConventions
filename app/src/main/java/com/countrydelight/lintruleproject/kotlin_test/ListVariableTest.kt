package com.countrydelight.lintruleproject.kotlin_test

class ListVariableTest {

    val wrongArrayListVariable = arrayListOf<String>()

    val rightArrayList = arrayListOf<String>()

    val wrongMutableListVariable = mutableListOf<String>()

    val rightMutableList = mutableListOf<String>()

    val wrongListVariable = listOf<String>()

    val rightList = listOf<String>()

    lateinit var wrongLateInit: List<String>

    val rightPublicList: List<String>? = null


    // checks list rule inside function
    fun checkListRule() {
        var hello = arrayListOf<String>()
    }

}

object ListVariableTestObjectClass {

    val rightList = listOf<String>()

    val wrongListVariable = arrayListOf<String>()

    var wrongPublicListVariable = arrayListOf<String>()

    var rightPublicList = arrayListOf<String>()


    fun MutableList<String>.sortByName() {
        this.sortBy { it }
    }
}