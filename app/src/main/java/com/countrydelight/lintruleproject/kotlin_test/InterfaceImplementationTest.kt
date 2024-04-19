package com.countrydelight.lintruleproject.kotlin_test

import androidx.activity.ComponentActivity

interface IKotlinTest {
}


class WrongImplClass : IKotlinTest {

}


class RightImpl : IKotlinTest {

}


class TestActivity : ComponentActivity(), IKotlinTest