package com.example.blockchainapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.blockchainapp.databinding.OneBlockBinding
import com.example.blockchainapp.domain.models.BlockModelItem

class BlockChainAdapter(context: Context, onBlockClicked: OnBlockClicked) :
    ListAdapter<BlockModelItem, BlockChainAdapter.BlockChainHolder>(
        object : DiffUtil.ItemCallback<BlockModelItem>() {

            override fun areItemsTheSame(
                oldItem: BlockModelItem,
                newItem: BlockModelItem
            ): Boolean {
                return oldItem.prevhash == newItem.prevhash
            }

            override fun areContentsTheSame(
                oldItem: BlockModelItem,
                newItem: BlockModelItem
            ): Boolean {
                return oldItem.data.data == newItem.data.data && oldItem.data.name == newItem.data.name
            }


        }) {
    private var onBlockClicked: OnBlockClicked? = null

    private var layoutInflater: LayoutInflater? = null

    init {
        this.onBlockClicked = onBlockClicked
        this.layoutInflater = LayoutInflater.from(context)

    }

    interface OnBlockClicked {
        fun onClick(blockModelItem: BlockModelItem)
    }

    inner class BlockChainHolder(val binding: OneBlockBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            with(binding.root) {
                setOnClickListener {
                    val item = getItem(layoutPosition)
                    onBlockClicked?.onClick(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockChainHolder {
        return BlockChainHolder(
            OneBlockBinding.inflate(
                checkNotNull(layoutInflater),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BlockChainHolder, position: Int) {
        with(holder) {
            binding.data.text = getItem(position).data.data
            binding.name.text = getItem(position).data.name
        }
    }
}
