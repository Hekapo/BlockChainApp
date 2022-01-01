package com.example.blockchainapp.domain.models

data class NewBlockResponse(
    val status: Int,
    val statusString: String,
    val block: BlockModelItem
)

