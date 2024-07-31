package com.countrydelight.lintruleproject.java_test.find_view_by_id_test;

import android.view.LayoutInflater;
import android.view.View;

import com.countrydelight.lintruleproject.R;
import com.countrydelight.lintruleproject.databinding.LayoutTestIdBinding;

public class FindViewByIdTest {


    // using find view by id
    public void usingFindViewById(View view) {
        view.findViewById(R.id.hello);
    }

    // using view binding
    public void usingViewBinding(LayoutInflater layoutInflater) {
        LayoutTestIdBinding.inflate(layoutInflater);
    }
}
