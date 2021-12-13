package com.example.blockchainapp.data.mapper

import com.example.blockchainapp.data.database.DataDB
import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.models.Data

object DataDBMapper {

    fun transform(dataEntity: DataDB): Data {
        return Data(dataEntity.data, dataEntity.name)
    }

    fun transformToEntity(data: List<BlockModelItem>): List<DataDB> {
        val list = mutableListOf<DataDB>()
        data.forEach {
            list.add(DataDB(id = 0, data = it.data.data, name = it.data.name))
        }
        return list

    }
}
