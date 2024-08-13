package com.countrydelight.lintruleproject.java_test;

public class FunctionExceptionHandleTest {

    // throws exception
    void testThrowException() throws ArithmeticException {

    }

    //wrong test catch exception
    void wrongTestExceptionAtFunctionLevel() {
        testThrowException();
    }

    //right test catch exception
    void rightTestExceptionAtFunctionLevelByThrowingExceptionOnly() throws Exception {
        testThrowException();
    }

    //right test catch exception
    void rightTestExceptionAtFunctionLevelByThrowingParticularException() throws ArithmeticException {
        testThrowException();
    }

    //
    void rightTestExceptionHandleAtTryCatchLevelByCatchingExceptionOnly() {
        try {
            testThrowException();
        } catch (Exception exception) {

        }
    }

    void rightTestExceptionHandleAtTryCatchLevelByCatchingParticularException() {
        try {
            testThrowException();
        } catch (ArithmeticException exception) {

        }
    }
}
