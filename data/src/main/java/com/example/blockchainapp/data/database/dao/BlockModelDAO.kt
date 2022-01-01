package com.example.blockchainapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.blockchainapp.data.database.entities.BlockModelDB

@Dao
interface BlockModelDAO {

    @Insert(entity = BlockModelDB::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertBlock(blockModelDB: List<BlockModelDB>)

}
