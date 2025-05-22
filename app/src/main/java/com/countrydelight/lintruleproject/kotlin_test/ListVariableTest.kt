package com.countrydelight.lintruleproject.kotlin_test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ListVariableTest {

    val wrongArrayListVariable = arrayListOf<String>()

    val rightArrayList = arrayListOf<String>()

    val wrongMutableListVariable = mutableListOf<String>()

    val rightMutableList = mutableListOf<String>()

    val wrongListVariable = listOf<String>()

    val rightList = listOf<String>()

    lateinit var wrongLateInit: List<String>

    var nullableList: ArrayList<Int>? = arrayListOf()

    var nonNullableList = nullableList ?: arrayListOf()

    val rightPublicList: List<String>? = null

    var selectedOption: Int? by mutableStateOf(null)


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