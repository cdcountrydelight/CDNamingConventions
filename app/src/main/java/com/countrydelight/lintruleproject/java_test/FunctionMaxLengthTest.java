package com.countrydelight.lintruleproject.java_test;

public class FunctionMaxLengthTest {

    // right function with max length
    public String rightFunctionMaxLength() {
        return "Hello";
    }

    // wrong fun max length
    public void wrongFunMaxLength() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        int h = 8;
        int i = 9;
        int j = 10;
        int k = 11;
        int l = 12;
        int m = 13;
        int n = 14;
        int o = 15;
        int p = 16;
        int q = 17;
        int r = 18;
        int s = 19;
        int t = 20;
        int u = 21;
        int v = 22;
        int w = 23;
        int x = 24;
        int y = 25;
        int z = 26;

        for (int i1 = 0; i1 < 10; i1++) {
            a += i1;
            b -= i1;
            c *= i1;
            d /= (i1 + 1);
            e += i1;
            f -= i1;
            g *= i1;
            h /= (i1 + 1);
            i += i1;
            j -= i1;
            k *= i1;
            l /= (i1 + 1);
            m += i1;
            n -= i1;
            o *= i1;
            p /= (i1 + 1);
            q += i1;
            r -= i1;
            s *= i1;
            t /= (i1 + 1);
            u += i1;
            v -= i1;
            w *= i1;
            x /= (i1 + 1);
            y += i1;
            z -= i1;
        }

        if (a > 10) {
            a = 0;
        }

        switch (b) {
            case 1:
                a++;
                break;
            case 2:
                a--;
                break;
            case 3:
                a *= 2;
                break;
            default:
                a /= 2;
                break;
        }

        while (c < 100) {
            c += 5;
        }

        try {
            int result = a / (b + 1);
            System.out.println("Result: " + result);
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by zero");
        }

        String[] array = new String[10];
        for (int i2 = 0; i2 < array.length; i2++) {
            array[i2] = "Element " + i2;
        }

        for (String element : array) {
            System.out.println(element);
        }

        int sum = 0;
        for (int i3 = 1; i3 <= 100; i3++) {
            sum += i3;
        }

        System.out.println("Sum: " + sum);
    }
}
