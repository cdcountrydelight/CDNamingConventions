package com.countrydelight.lintruleproject.kotlin_test

class NestedLoopsTest {

    //right loop structure
    fun rightLoopStructure() {
        val testList = listOf(1, 2, 3)
        testList.forEach {
            println(it)
        }
    }

    // wrong for loop structure
    fun wrongForLoopStructure() {
        val testList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        for (i in testList) {
            for (j in i) {
                println(j)
            }
        }
    }

    //wrong while loop structure
    fun wrongWhileLoopStructure() {
        val testList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        var i = 0
        while (i < testList.size) {
            var j = 0
            while (j < testList[i].size) {
                println(testList[i][j])
                j++
            }
            i++
        }
    }

    //wrong for while loop structure
    fun wrongForEachLoopStructure() {
        val testList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        testList.forEach { childList ->
            childList.forEach {

            }
        }
    }
}