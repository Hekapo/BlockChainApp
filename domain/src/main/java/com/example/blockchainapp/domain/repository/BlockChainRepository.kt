package com.example.blockchainapp.domain.repository

import com.example.blockchainapp.domain.models.BlockModel
import com.example.blockchainapp.domain.models.BlockModelItem

interface BlockChainRepository {
    suspend fun getAllBlockChain(): BlockModel?

    suspend fun insertAllBlockChain(item: List<BlockModelItem>)
}
