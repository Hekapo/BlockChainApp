package com.example.blockchainapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockchainapp.domain.models.BlockModel
import com.example.blockchainapp.domain.usecase.GetAllBlockChainUseCase
import com.example.blockchainapp.domain.usecase.InsertAllBlockChainUseCase
import com.example.blockchainapp.domain.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBlockChainUseCase: GetAllBlockChainUseCase,
    private val insertAllBlockChainUseCase: InsertAllBlockChainUseCase
) : ViewModel() {

    private val _blockChainFLow = MutableStateFlow<State<BlockModel>>(State.loading(null))
    val blockChainFLow: StateFlow<State<BlockModel>> = _blockChainFLow.asStateFlow()


    init {
        getBlockChain()
        insert()
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

    fun insert() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getAllBlockChainUseCase.execute()
            if (result != null) {
                insertAllBlockChainUseCase.execute(result)
            }
        }
    }
}
