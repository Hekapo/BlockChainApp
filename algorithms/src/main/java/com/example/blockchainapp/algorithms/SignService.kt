package com.example.blockchainapp.algorithms

import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.models.Data
import org.bouncycastle.util.encoders.Hex
import java.nio.charset.StandardCharsets
import java.security.*
import java.security.spec.PKCS8EncodedKeySpec


class SignService {

    fun generateSignature(data: String, name: String): String {
        val newData = Data(data, name)

        return String(Hex.encode(generateRSAPSSSignature(newData.toString().toByteArray())))

    }

    fun prevHash(block: List<BlockModelItem>): String {

        return String(Hex.encode(getHash(block[block.size - 1])))

    }

    @Throws(Exception::class)
    private fun generateRSAPSSSignature(input: ByteArray?): ByteArray? {
        val signature: Signature = Signature.getInstance(SIGN_ALGORITHM)
        signature.initSign(
            convertArrayToPrivateKey(
                Hex.decode(MakeKeyPair.private),
                KEY_ALGORITHM
            )
        )
        signature.update(input)
        return signature.sign()
    }

    private fun concat(a: ByteArray?, b: ByteArray?): ByteArray? {
        if (a == null) return b
        if (b == null) return a
        val aLength = a.size
        val bLength = b.size
        val c = ByteArray(aLength + bLength)
        System.arraycopy(a, 0, c, 0, aLength)
        System.arraycopy(b, 0, c, aLength, bLength)
        return c
    }

    @Throws(java.lang.Exception::class)
    private fun convertArrayToPrivateKey(
        encoded: ByteArray?,
        algorithm: String?
    ): PrivateKey? {
        val keySpec = PKCS8EncodedKeySpec(encoded)
        val keyFactory: KeyFactory = KeyFactory.getInstance(algorithm)

        return keyFactory.generatePrivate(keySpec)
    }

    @Throws(NoSuchAlgorithmException::class)
    fun getHash(block: BlockModelItem): ByteArray? {
        val digest: MessageDigest = MessageDigest.getInstance(DIGEST_ALGORITHM)
        return digest.digest(
            concat(
                concat(
                    if (block.prevhash != null) block.prevhash?.toByteArray() else null,
                    block.data.toString().toByteArray(StandardCharsets.UTF_8)
                ),
                block.ts.toByteArray()
            )
        )
    }

    companion object {
        private const val KEY_ALGORITHM = "RSA"
        private const val DIGEST_ALGORITHM = "SHA-256"
        private const val SIGN_ALGORITHM = "SHA256withRSA"
    }
}
