package com.countrydelight.lintruleproject.java_test.variable_scope;

public class RightGlobalVariableScope {

    private final String rightGlobalVariableScope = "right_scope";

    public void rightGlobalVariableScope1() {
        System.out.println(rightGlobalVariableScope.length());
    }

    private void rightGlobalVariableScope2() {
        System.out.println(rightGlobalVariableScope.length());
    }

}
