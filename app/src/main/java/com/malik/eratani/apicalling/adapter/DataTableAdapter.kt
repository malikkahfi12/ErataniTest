package com.malik.eratani.apicalling.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malik.eratani.apicalling.model.DataTable
import com.malik.eratani.databinding.ItemTableBinding

class DataTableAdapter(private val context : Context) : ListAdapter<DataTable, DataTableAdapter.DataTableViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataTableAdapter.DataTableViewHolder {
        val binding = ItemTableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataTableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataTableAdapter.DataTableViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DataTableViewHolder(private val binding : ItemTableBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : DataTable){
            binding.apply {
                itemName.text = data.name
                itemEmail.text = data.email
                itemGender.text =data.gender
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DataTable>(){
        override fun areItemsTheSame(oldItem: DataTable, newItem: DataTable): Boolean {
            return oldItem.email == newItem.email
        }

        override fun areContentsTheSame(oldItem: DataTable, newItem: DataTable): Boolean {
            return oldItem == newItem
        }

    }
}