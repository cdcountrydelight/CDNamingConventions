package com.countrydelight.lintruleproject.kotlin_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class WrongBroadCastReceiverClass : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
    }
}


class RightBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
    }
}