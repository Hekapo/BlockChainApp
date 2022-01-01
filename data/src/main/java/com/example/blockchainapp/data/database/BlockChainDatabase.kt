package com.example.blockchainapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blockchainapp.data.database.dao.BlockModelDAO
import com.example.blockchainapp.data.database.dao.DataDAO
import com.example.blockchainapp.data.database.entities.BlockModelDB
import com.example.blockchainapp.data.database.entities.DataDB

@Database(entities = [DataDB::class, BlockModelDB::class], version = 1, exportSchema = false)
abstract class BlockChainDatabase : RoomDatabase() {

    abstract fun blockModelDao(): BlockModelDAO

    abstract fun blockDataDao(): DataDAO


}
