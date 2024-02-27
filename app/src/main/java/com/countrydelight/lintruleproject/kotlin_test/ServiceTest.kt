package com.countrydelight.lintruleproject.kotlin_test

import android.app.Service
import android.content.Intent
import android.os.IBinder

class WrongServiceClass : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}


class RightService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}