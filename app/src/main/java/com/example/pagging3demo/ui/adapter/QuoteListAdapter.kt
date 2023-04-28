package com.example.pagging3demo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagging3demo.R
import com.example.pagging3demo.databinding.ItemLoaderBinding
import com.example.pagging3demo.databinding.ItemQuoteLayoutBinding

class QuoteListAdapter : PagingDataAdapter<com.example.pagging3demo.models.Result, QuoteListAdapter.QuoteViewHolder>(COMPARATOR) {

    class QuoteViewHolder(private val binding: ItemQuoteLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(data:com.example.pagging3demo.models.Result){
           binding.apply {
                tvQuotes.text=data.content
           }
       }
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding=DataBindingUtil.inflate<ItemQuoteLayoutBinding>(LayoutInflater.from(parent.context),R.layout.item_quote_layout,parent,false)
        return QuoteViewHolder(binding)
    }
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<com.example.pagging3demo.models.Result>() {
            override fun areItemsTheSame(oldItem: com.example.pagging3demo.models.Result, newItem: com.example.pagging3demo.models.Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: com.example.pagging3demo.models.Result, newItem: com.example.pagging3demo.models.Result): Boolean {
                return oldItem == newItem
            }
        }
    }
}