package com.countrydelight.lintruleproject.kotlin_test.function_comment_test

class FunctionCommentTestImpl : IFunctionCommentTest {


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