package com.example.blockchainapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataDB::class, BlockModelDB::class], version = 1, exportSchema = false)
abstract class BlockChainDatabase : RoomDatabase() {

    abstract fun blockModelDao(): BlockModelDAO

    abstract fun blockDataDao(): DataDAO


}
