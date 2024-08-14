package com.countrydelight.lintruleproject.kotlin_test

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Upsert

@Dao
interface UpsertTestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData()

    @Upsert
    fun upsertData()


}