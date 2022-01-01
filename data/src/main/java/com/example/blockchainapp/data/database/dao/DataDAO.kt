package com.example.blockchainapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.blockchainapp.data.database.entities.DataDB

@Dao
interface DataDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: List<DataDB>): List<Long>
}
