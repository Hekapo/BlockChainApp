package com.example.blockchainapp.data.mapper

import com.example.blockchainapp.data.database.BlockModelDB
import com.example.blockchainapp.domain.models.BlockModelItem

object BlockModelDBMapper {

    fun transformToEntity(
        blockModelItem: List<BlockModelItem>,
        id: List<Long>
    ): List<BlockModelDB> {
        val list = mutableListOf<BlockModelDB>()
        for (i in blockModelItem.indices) {
            list.add(
                BlockModelDB(
                    id = 0,
                    data_id = id[i],
                    prevHash = blockModelItem[i].prevhash ?: "",
                    publicKey = blockModelItem[i].publickey ?: "",
                    signature = blockModelItem[i].signature ?: "",
                    ts = blockModelItem[i].ts
                )
            )

        }

        return list
    }


}
