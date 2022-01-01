package com.example.blockchainapp.di

import com.example.blockchainapp.data.database.dao.BlockModelDAO
import com.example.blockchainapp.data.database.dao.DataDAO
import com.example.blockchainapp.data.network.BlockChainService
import com.example.blockchainapp.data.repository.BlockChainRepositoryIml
import com.example.blockchainapp.domain.repository.BlockChainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideBlockChainRepository(
        service: BlockChainService,
        dao: BlockModelDAO,
        dataDAO: DataDAO
    ): BlockChainRepository {
        return BlockChainRepositoryIml(service, dataDAO, dao)
    }
}
