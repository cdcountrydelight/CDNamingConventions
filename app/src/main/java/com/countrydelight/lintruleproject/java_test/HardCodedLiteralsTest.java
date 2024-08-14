package com.countrydelight.lintruleproject.java_test;

import static kotlin.random.RandomKt.Random;

public class HardCodedLiteralsTest {

    // comment
    public void hardCodedNumberTest() {
        int a = 100;
        a = getA();
        boolean res = a == 100;
        if (a == 100) {
            a = 200;
        }
    }

    // comment
    private int getA() {
        return Random(100).nextInt();
    }

}
