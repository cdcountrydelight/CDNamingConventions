package com.countrydelight.lintruleproject.java_test;

import android.os.Build;

import java.util.ArrayList;

public class NestedLoopTest {

    //right loop structure
    void rightLoopStructure() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        for (int i = 0; i < testList.size(); i++) {
            System.out.println("Hello");
        }
    }

    // wrong for loop structure
    void wrongForLoopStructure() {
        ArrayList<ArrayList<Integer>> testList = new ArrayList<>();
        ArrayList<Integer> dummyList = new ArrayList<>();
        dummyList.add(1);
        dummyList.add(2);
        dummyList.add(3);
        testList.add(dummyList);
        testList.add(dummyList);
        testList.add(dummyList);
        for (int i = 0; i < testList.size(); i++) {
            for (int j = 0; j < testList.get(i).size(); j++) {
                System.out.println((testList.get(i).get(j)));
            }
        }
    }

    //wrong while loop structure
    void wrongWhileLoopStructure() {
        ArrayList<ArrayList<Integer>> testList = new ArrayList<>();
        ArrayList<Integer> dummyList = new ArrayList<>();
        dummyList.add(1);
        dummyList.add(2);
        dummyList.add(3);
        testList.add(dummyList);
        testList.add(dummyList);
        testList.add(dummyList);
        int i = 0;
        while (i < testList.size()) {
            int j = 0;
            while (j < testList.get(i).size()) {
                System.out.println((testList.get(i).get(j)));
                j++;
            }
            i++;
        }
    }

    //wrong for while loop structure
    void wrongForEachLoopStructure() {
        ArrayList<ArrayList<Integer>> testList = new ArrayList<>();
        ArrayList<Integer> dummyList = new ArrayList<>();
        dummyList.add(1);
        dummyList.add(2);
        dummyList.add(3);
        testList.add(dummyList);
        testList.add(dummyList);
        testList.add(dummyList);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            testList.forEach(childList -> {
                childList.forEach(integer -> {

                });
            });
        }
    }
}
