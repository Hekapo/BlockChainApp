package com.example.blockchainapp.domain.repository

import com.example.blockchainapp.domain.models.BlockModel
import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.models.NewBlockResponse

interface BlockChainRepository {
    suspend fun getAllBlockChain(): BlockModel?

    suspend fun insertAllBlockChain(item: List<BlockModelItem>)

    suspend fun sendBlock(
        newBlockResponse: String
//        data: Data,
//        prevHash: String,
//        publicKey: String,
//        signature: String,
//        ts: String
    )
}
