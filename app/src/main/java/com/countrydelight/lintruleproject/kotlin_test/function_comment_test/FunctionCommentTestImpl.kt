package com.countrydelight.lintruleproject.kotlin_test.function_comment_test

import androidx.compose.runtime.mutableStateOf

class FunctionCommentTestImpl : IFunctionCommentTest {

    val testCommentState = mutableStateOf<String>("")


    override fun testComment() {
        TODO("Not yet implemented")
    }


    fun withoutComment() {

    }


    // has comments
    fun withComment() {

    }


}

enum class TestingEnum {
    First,
    Second,
    Third
}

data class TestingDataClass(
    val first: String,
    val second: String,
)