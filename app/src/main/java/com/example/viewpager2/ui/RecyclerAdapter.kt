package com.example.viewpager2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.DataModel.image
import com.example.viewpager2.R
import com.example.viewpager2.databinding.RecyclerItemBinding
import com.squareup.picasso.Picasso

class RecyclerAdapter(val context: Context) :
    ListAdapter<image, RecyclerAdapter.ItemViewHolder>(DiffCallback()) {

    private lateinit var binding: RecyclerItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        binding = RecyclerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(binding)

    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(private val binding: RecyclerItemBinding) :

        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: image) {
            Picasso.get().load(item.largeImageURL).placeholder(R.drawable.image).into(binding.imageItem)
        }

    }
}
class DiffCallback : DiffUtil.ItemCallback<image>() {
    override fun areItemsTheSame(oldItem: image, newItem: image): Boolean {
        return oldItem?.id == newItem?.id
    }

    override fun areContentsTheSame(oldItem: image, newItem: image): Boolean {
        return oldItem.largeImageURL == newItem.largeImageURL
    }
}
