package com.example.blockchainapp.data.repository

import com.example.blockchainapp.data.database.dao.BlockModelDAO
import com.example.blockchainapp.data.database.dao.DataDAO
import com.example.blockchainapp.data.mapper.BlockModelDBMapper
import com.example.blockchainapp.data.mapper.DataDBMapper
import com.example.blockchainapp.data.network.BlockChainService
import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.models.Data
import com.example.blockchainapp.domain.models.NewBlockResponse
import com.example.blockchainapp.domain.repository.BlockChainRepository

class BlockChainRepositoryIml(
    private val blockChainService: BlockChainService,
    private val dao: DataDAO,
    private val blockModelDAO: BlockModelDAO
) : BlockChainRepository {

    override suspend fun getAllBlockChain() = blockChainService.getAllBlockChain().body()

    override suspend fun insertAllBlockChain(item: List<BlockModelItem>) {
        val id = dao.insert(DataDBMapper.transformToEntity(item))

        blockModelDAO.insertBlock(BlockModelDBMapper.transformToEntity(item, id))

    }

    override suspend fun sendBlock(
        newBlockResponse: String
//        data: Data,
//        prevHash: String,
//        publicKey: String,
//        signature: String,
//        ts: String
    ) {
        blockChainService.sendBlock(newBlockResponse)
    }

}
