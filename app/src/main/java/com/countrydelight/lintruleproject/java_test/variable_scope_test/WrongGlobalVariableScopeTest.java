package com.countrydelight.lintruleproject.java_test.variable_scope_test;

public class WrongGlobalVariableScopeTest {

    private final String wrongGlobalVariableScope = "wrong_scope";

    public void wrongGlobalVariableScope() {
        System.out.println(wrongGlobalVariableScope.length());
    }
}
