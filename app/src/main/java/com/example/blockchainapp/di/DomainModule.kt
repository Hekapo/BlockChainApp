package com.example.blockchainapp.di

import com.example.blockchainapp.domain.repository.BlockChainRepository
import com.example.blockchainapp.domain.usecase.GetAllBlockChainUseCase
import com.example.blockchainapp.domain.usecase.InsertAllBlockChainUseCase
import com.example.blockchainapp.domain.usecase.SendBlockUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllBlockChainUseCase(repository: BlockChainRepository): GetAllBlockChainUseCase {
        return GetAllBlockChainUseCase(repository)
    }

    @Provides
    fun provideInsertAllBlockChainUseCase(repository: BlockChainRepository): InsertAllBlockChainUseCase {
        return InsertAllBlockChainUseCase(repository)
    }

    @Provides
    fun provideSendBlockUseCase(repository: BlockChainRepository): SendBlockUseCase {
        return SendBlockUseCase(repository)
    }
}
