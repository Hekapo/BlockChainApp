package com.example.blockchainapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "block_data"
)
data class DataDB(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val data: String,
    val name: String
)
