package com.example.blockchainapp.domain.usecase

import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.repository.BlockChainRepository

class InsertAllBlockChainUseCase(private val repository: BlockChainRepository) {
    suspend fun execute(item: List<BlockModelItem>) = repository.insertAllBlockChain(item)

}
