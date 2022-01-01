package com.example.blockchainapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockchainapp.algorithms.MakeKeyPair
import com.example.blockchainapp.algorithms.SignService
import com.example.blockchainapp.domain.models.BlockModel
import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.models.Data
import com.example.blockchainapp.domain.models.NewBlockResponse
import com.example.blockchainapp.domain.usecase.GetAllBlockChainUseCase
import com.example.blockchainapp.domain.usecase.InsertAllBlockChainUseCase
import com.example.blockchainapp.domain.usecase.SendBlockUseCase
import com.example.blockchainapp.domain.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBlockChainUseCase: GetAllBlockChainUseCase,
    private val insertAllBlockChainUseCase: InsertAllBlockChainUseCase,
    private val sendBlockUseCase: SendBlockUseCase
) : ViewModel() {

    private val _blockChainFLow = MutableStateFlow<State<BlockModel>>(State.loading(null))
    val blockChainFLow: StateFlow<State<BlockModel>> = _blockChainFLow.asStateFlow()

    private val _sendBlockChainFLow = MutableStateFlow<State<BlockModel>>(State.loading(null))
    val sendBlockChainFLow: StateFlow<State<BlockModel>> = _blockChainFLow.asStateFlow()

    @Inject
    lateinit var signService: SignService

    init {
        getBlockChain()
    }

    fun getBlockChain() {
        viewModelScope.launch {
            val result = getAllBlockChainUseCase.execute()
            if (result != null) {
                _blockChainFLow.value = State.success(result)

            } else {
                _blockChainFLow.value = State.error("Error", null)
            }
        }
    }

    fun insert(item: List<BlockModelItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            insertAllBlockChainUseCase.execute(item)
        }
    }

    fun sendBlock(data: String, name: String) {
        viewModelScope.launch {
            val result = getAllBlockChainUseCase.execute()

            val newData = Data(data, name)
            val signature = signService.generateSignature(data, name)
            if (result != null) {
                val prevHash = signService.prevHash(result)
                val blockModelItem =
                    BlockModelItem(newData, prevHash, MakeKeyPair.public, signature, "")

//                val newBLock = NewBlockResponse(-1, "", blockModelItem)

                sendBlockUseCase.execute(URLEncoder.encode(blockModelItem.toString(), "UTF-8"))
            }

        }

    }
}
