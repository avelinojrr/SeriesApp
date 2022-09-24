package com.example.seriesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.seriesapp.databinding.TvShowLayoutAdapterBinding
import com.example.seriesapp.models.TvShowItem

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffcalbak = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffcalbak)
    var tvShow: List<TvShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curretTvShow = tvShow[position]

        holder.binding.apply {
            textView.text = curretTvShow.name

            imageView.load(curretTvShow.image.original){
                crossfade(true)
                crossfade(1000)

            }
        }
    }

    override fun getItemCount() = tvShow.size

}













