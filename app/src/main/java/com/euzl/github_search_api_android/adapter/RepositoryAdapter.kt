package com.euzl.github_search_api_android.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.euzl.github_search_api_android.databinding.ListItemRepositoryBinding
import com.euzl.github_search_api_android.dto.RepositoryDto

class RepositoryAdapter(val context: Context, val list:List<RepositoryDto>)
    : RecyclerView.Adapter<RepositoryAdapter.RepositoryHolder>() {
        inner class RepositoryHolder(private val binding: ListItemRepositoryBinding)
            : RecyclerView.ViewHolder(binding.root) {
                fun bind(item: RepositoryDto) {
                    binding.apply {
                        dto = item
                        Log.d("adapter", "bind: ${item.starCount}")
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryHolder {
        val listItemRepositoryBinding =
            ListItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryHolder(listItemRepositoryBinding)
    }

    override fun onBindViewHolder(holder: RepositoryHolder, position: Int) {
        val dto = list[position]
        holder.apply {
            bind(dto)
            itemView.tag = dto
        }
    }

    override fun getItemCount(): Int = list.size
}