package com.example.blockchainapp.di

import com.example.blockchainapp.algorithms.SignService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlgorithmsModule {

    @Provides
    @Singleton
    fun provideSignService(): SignService {
        return SignService()
    }

}
