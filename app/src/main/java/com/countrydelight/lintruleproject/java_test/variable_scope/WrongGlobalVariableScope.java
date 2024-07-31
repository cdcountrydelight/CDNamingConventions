package com.countrydelight.lintruleproject.java_test.variable_scope;

public class WrongGlobalVariableScope {

    private final String wrongGlobalVariableScope = "wrong_scope";

    public void wrongGlobalVariableScope() {
        System.out.println(wrongGlobalVariableScope.length());
    }
}
