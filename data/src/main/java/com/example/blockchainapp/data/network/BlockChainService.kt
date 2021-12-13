package com.example.blockchainapp.data.network

import com.example.blockchainapp.domain.models.BlockModel
import retrofit2.Response
import retrofit2.http.GET

interface BlockChainService {

    //http://188.93.211.195/dis/chain

    @GET("chain/")
    suspend fun getAllBlockChain(): Response<BlockModel>
}
