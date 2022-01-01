package com.example.blockchainapp.algorithms

import android.content.Context
import com.example.blockchainapp.algorithms.MakeKeyPair.private
import com.example.blockchainapp.algorithms.MakeKeyPair.public
import java.io.File

class SaveKeys(private val context: Context) {

    fun saveKeys() {
        val publicKey = File(context.filesDir, "public.key")
        val privateKey = File(context.filesDir, "private.key")

        if (!(publicKey.exists() && privateKey.exists())) {

            context.openFileOutput("public.key", Context.MODE_PRIVATE).use {
                it.write(public.toByteArray())
            }
            context.openFileOutput("private.key", Context.MODE_PRIVATE).use {
                it.write(private.toByteArray())
            }

        }

    }
}
