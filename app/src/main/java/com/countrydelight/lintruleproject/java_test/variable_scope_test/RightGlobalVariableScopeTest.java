package com.countrydelight.lintruleproject.java_test.variable_scope_test;

import android.content.Context;
import android.view.View;

public class RightGlobalVariableScopeTest extends View {

    private final String rightGlobalVariableScope = "right_scope";

    public RightGlobalVariableScopeTest(Context context) {
        super(context);
    }

    public void rightGlobalVariableScope1() {
        System.out.println(rightGlobalVariableScope.length());
    }

    private void rightGlobalVariableScope2() {
        System.out.println(rightGlobalVariableScope.length());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
