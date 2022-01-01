package com.example.blockchainapp.domain.usecase

import com.example.blockchainapp.domain.repository.BlockChainRepository

class SendBlockUseCase(private val repository: BlockChainRepository) {

    suspend fun execute(
        newBlockResponse: String
    ) = repository.sendBlock(newBlockResponse)
}
