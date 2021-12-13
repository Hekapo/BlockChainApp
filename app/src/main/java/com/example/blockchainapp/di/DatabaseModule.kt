package com.example.blockchainapp.di

import android.content.Context
import androidx.room.Room
import com.example.blockchainapp.data.database.BlockChainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        BlockChainDatabase::class.java,
        "block_chain_db"
    ).build()


    @Singleton
    @Provides
    fun provideBlockModelDao(db: BlockChainDatabase) = db.blockModelDao()

    @Singleton
    @Provides
    fun provideBlockDataDao(db: BlockChainDatabase) = db.blockDataDao()
}
