package com.countrydelight.lintruleproject.kotlin_test

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.countrydelight.lintruleproject.R
import com.countrydelight.lintruleproject.databinding.LayoutTestIdBinding

class FindViewByIdTest {

    // using find view by id
    fun usingFindViewById(view: View) {
        view.findViewById<TextView>(R.id.hello)
    }


    // using view binding
    fun usingViewBinding(layoutInflater: LayoutInflater) {
        LayoutTestIdBinding.inflate(layoutInflater)
    }
}