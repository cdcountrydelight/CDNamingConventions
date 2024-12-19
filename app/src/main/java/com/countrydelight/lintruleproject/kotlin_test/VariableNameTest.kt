package com.countrydelight.lintruleproject.kotlin_test

import android.content.Context
import android.view.View

class VariableNameTest(context: Context) : View(context) {

    private var a = 10

    private var wrongBooleanVariableName: Boolean = true

    private var isBooleanVariableName: Boolean = true


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }


    fun Long.toBoolean() = when (this) {
        0L -> false
        else -> true
    }

}