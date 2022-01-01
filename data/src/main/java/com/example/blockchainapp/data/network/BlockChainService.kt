package com.example.blockchainapp.data.network

import com.example.blockchainapp.domain.models.BlockModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BlockChainService {

    //http://188.93.211.195/dis/chain

    @GET("chain/")
    suspend fun getAllBlockChain(): Response<BlockModel>

    //http://localhost:8090/dis/newblock?block=


    @POST("newblock?block=")
    suspend fun sendBlock(
        @Body item: String
//        @Field("data") data: Data,
//        @Field("prevhash") prevhash: String,
//        @Field("publickey") publickey: String,
//        @Field("signature") signature: String,
//        @Field("ts") ts: String
    )
}
