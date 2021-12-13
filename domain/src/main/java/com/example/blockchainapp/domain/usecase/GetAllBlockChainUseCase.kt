package com.example.blockchainapp.domain.usecase

import com.example.blockchainapp.domain.repository.BlockChainRepository

class GetAllBlockChainUseCase(private val repository: BlockChainRepository) {
    suspend fun execute() = repository.getAllBlockChain()
}
