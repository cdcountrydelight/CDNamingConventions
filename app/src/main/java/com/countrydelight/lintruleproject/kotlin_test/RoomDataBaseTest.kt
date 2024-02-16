package com.countrydelight.lintruleproject.kotlin_test

import androidx.room.RoomDatabase

abstract class WrongRoomDatabaseClass : RoomDatabase() {

}


abstract class RightRoomDatabase : RoomDatabase() {

}