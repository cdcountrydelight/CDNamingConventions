package com.countrydelight.lintruleproject.kotlin_test

class FunctionExceptionHandleTest {

    // throws exception
    @Throws(ArithmeticException::class)
    fun testThrowException() {

    }

    //wrong test catch exception
    fun wrongTestExceptionAtFunctionLevel() {
        testThrowException()
    }

    //right test catch exception
    @Throws(Exception::class)
    fun rightTestExceptionAtFunctionLevelByThrowingExceptionOnly() {
        testThrowException()
    }

    //right test catch exception
    @Throws(ArithmeticException::class)
    fun rightTestExceptionAtFunctionLevelByThrowingParticularException() {
        testThrowException()
    }

    //
    fun rightTestExceptionHandleAtTryCatchLevelByCatchingExceptionOnly() {
        try {
            testThrowException()
        } catch (exception: Exception) {

        }
    }

    fun rightTestExceptionHandleAtTryCatchLevelByCatchingParticularException() {
        try {
            testThrowException()
        } catch (exception: ArithmeticException) {

        }
    }
}