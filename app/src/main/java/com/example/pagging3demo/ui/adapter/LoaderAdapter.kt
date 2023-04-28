package com.example.pagging3demo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagging3demo.R
import com.example.pagging3demo.databinding.ItemLoaderBinding

class LoaderAdapter:LoadStateAdapter<LoaderAdapter.LoadViewHolder>() {


    class LoadViewHolder(private val binding: ItemLoaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState:LoadState){
            binding.apply {
                progressBarLoding.isVisible=loadState is LoadState.Loading
            }
        }
    }

    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHolder {
        val binding= DataBindingUtil.inflate<ItemLoaderBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_loader,parent,false)
        return LoadViewHolder(binding)
    }
}