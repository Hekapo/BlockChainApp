package com.example.blockchainapp.algorithms

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.util.encoders.Hex
import java.security.*

object MakeKeyPair {
    private var keyPairGenerator: KeyPairGenerator

    init {
        Security.addProvider(BouncyCastleProvider())
        keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(1024, SecureRandom())
    }

    private val keyPair = keyPairGenerator.genKeyPair()

    private val privateKey: PrivateKey = keyPair.private
    private val publicKey: PublicKey = keyPair.public

    val private = String(Hex.encode(privateKey.encoded))
    val public = String(Hex.encode(publicKey.encoded))


}

