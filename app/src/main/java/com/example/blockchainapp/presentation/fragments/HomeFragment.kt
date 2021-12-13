package com.example.blockchainapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blockchainapp.adapters.BlockChainAdapter
import com.example.blockchainapp.databinding.FragmentHomeBinding
import com.example.blockchainapp.domain.models.BlockModelItem
import com.example.blockchainapp.domain.utils.Status
import com.example.blockchainapp.extensions.launchWhenStarted
import com.example.blockchainapp.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment(), BlockChainAdapter.OnBlockClicked {
    private lateinit var binding: FragmentHomeBinding

    private val vm: HomeViewModel by viewModels()

    private val adapter: BlockChainAdapter by lazy {
        BlockChainAdapter(requireContext(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpRecyclerview()
        vm.blockChainFLow.onEach {
            when (it.status) {
                Status.LOADING -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {

                    it.data?.let { it1 -> setData(it1) }
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

                }
            }
        }.launchWhenStarted(lifecycleScope)


        return binding.root
    }

    fun setUpRecyclerview() {
        binding.blockRv.adapter = adapter
        binding.blockRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onClick(blockModelItem: BlockModelItem) {
    }

    fun setData(list: List<BlockModelItem>) {
        adapter.submitList(list)
    }
}
