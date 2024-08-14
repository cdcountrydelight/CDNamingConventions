package com.countrydelight.lintruleproject.kotlin_test

//right function with max length
fun rightFunctionMaxLength(): String {
    return "Hello World"
}

// wrong fun max length
fun wrongFunMaxLength() {
    var a = 1
    var b = 2
    var c = 3
    var d = 4
    var e = 5
    var f = 6
    var g = 7
    var h = 8
    var i = 9
    var j = 10
    var k = 11
    var l = 12
    var m = 13
    var n = 14
    var o = 15
    var p = 16
    var q = 17
    var r = 18
    var s = 19
    var t = 20
    var u = 21
    var v = 22
    var w = 23
    var x = 24
    var y = 25
    var z = 26

    for (i1 in 0..9) {
        a += i1
        b -= i1
        c *= i1
        d /= (i1 + 1)
        e += i1
        f -= i1
        g *= i1
        h /= (i1 + 1)
        i += i1
        j -= i1
        k *= i1
        l /= (i1 + 1)
        m += i1
        n -= i1
        o *= i1
        p /= (i1 + 1)
        q += i1
        r -= i1
        s *= i1
        t /= (i1 + 1)
        u += i1
        v -= i1
        w *= i1
        x /= (i1 + 1)
        y += i1
        z -= i1
    }

    if (a > 10) {
        a = 0
    }

    when (b) {
        1 -> a++
        2 -> a--
        3 -> a *= 2
        else -> a /= 2
    }
    while (c < 100) {
        c += 5
    }

    try {
        val result = a / (b + 1)
        println("Result: $result")
    } catch (e: ArithmeticException) {
        println("Cannot divide by zero")
    }

    val array = arrayOfNulls<String>(10)
    for (i2 in array.indices) {
        array[i2] = "Element $i2"
    }

    for (element in array) {
        println(element)
    }

    var sum = 0
    for (i3 in 1..100) {
        sum += i3
    }

    sum += a
    sum += b
    sum += c
    sum += d
    sum += e
    sum += f
    sum += g
    sum += h
    sum += i
    sum += j
    println("Sum: $sum")
}