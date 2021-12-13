package com.example.blockchainapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface DataDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: List<DataDB>): List<Long>
}
