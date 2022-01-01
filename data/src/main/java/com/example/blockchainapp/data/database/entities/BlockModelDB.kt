package com.example.blockchainapp.data.database.entities

import androidx.room.*

@Entity(
    tableName = "block_info",
    foreignKeys = [
        ForeignKey(
            entity = DataDB::class,
            parentColumns = ["id"],
            childColumns = ["data_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
            deferred = true
        )
    ],
    indices = [Index("data_id")],
)
data class BlockModelDB(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val data_id: Long,
    @ColumnInfo(name = "prev_hash")
    val prevHash: String?,
    @ColumnInfo(name = "public_key")
    val publicKey: String,
    val signature: String,
    val ts: String
)
