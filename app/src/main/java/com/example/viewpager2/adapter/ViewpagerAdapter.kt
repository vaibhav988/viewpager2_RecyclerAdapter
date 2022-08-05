package com.example.viewpager2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.databinding.ViewpagerItemBinding
import com.example.viewpager2.ui.RecyclerAdapter
import com.example.viewpager2.viewmodel.ImageViewModel


class ViewpagerAdapter(
    private val list: List<String>,
    private val context: Context, private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<ViewpagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewpagerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding, context, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(
        private val binding: ViewpagerItemBinding,
        private val context: Context,
        private val lifecycleOwner: LifecycleOwner
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filter: String) {
            val viewModel = ImageViewModel()
            viewModel.getImages(filter)
            val recyclerAdapter = RecyclerAdapter(context = context)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = recyclerAdapter
            }
            viewModel.listImages.observe(lifecycleOwner)
            {
                recyclerAdapter.submitList(it)
            }

        }

    }

}