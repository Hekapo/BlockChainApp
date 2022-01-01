package com.example.blockchainapp.domain.models

data class BlockModelItem(
    val `data`: Data,
    val prevhash: String? = null,
    val publickey: String? = null,
    val signature: String? = null,
    val ts: String
) {
    constructor() : this(Data("", ""), "", "", "", "")

    override fun toString(): String {
        return "{" +
                "\"prevhash\":\"" + prevhash + "\"," +
                "\"data\":" + data.toString() + "," +
                "\"signature\":\"" + signature + "\"," +
                "\"ts\":\"" + ts + "\"," +
                "\"publickey\":\"" + publickey + "\"}"
    }
}
