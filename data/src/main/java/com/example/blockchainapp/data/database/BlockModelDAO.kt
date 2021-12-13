package com.example.blockchainapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BlockModelDAO {

    @Insert(entity = BlockModelDB::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertBlock(blockModelDB: List<BlockModelDB>)

}
