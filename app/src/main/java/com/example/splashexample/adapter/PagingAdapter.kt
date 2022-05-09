package com.example.splashexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.splashexample.databinding.UnsplashSingleScreenBinding
import com.example.splashexample.model.data.UnsplashDataResponse
import com.example.splashexample.utils.glider

class PagingAdapter(val context : Context) : PagingDataAdapter<List<UnsplashDataResponse.UnsplashDataResponseItem>,PagingAdapter.MyViewHolder>(DataDiff) {


    class MyViewHolder(val binding: UnsplashSingleScreenBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.binding.nameText.text = getItem(position)?.get(0)?.description ?:""
        holder.binding.likeCOuntText.text = getItem(position)?.get(0)?.likes.toString()
        context.glider(getItem(position)?.get(0)?.urls?.regular!!,holder.binding.unsplashSingleImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(UnsplashSingleScreenBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }




    object DataDiff : DiffUtil.ItemCallback<List<UnsplashDataResponse.UnsplashDataResponseItem>>() {
        override fun areItemsTheSame(
            oldItem: List<UnsplashDataResponse.UnsplashDataResponseItem>,
            newItem: List<UnsplashDataResponse.UnsplashDataResponseItem>
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: List<UnsplashDataResponse.UnsplashDataResponseItem>,
            newItem: List<UnsplashDataResponse.UnsplashDataResponseItem>
        ): Boolean {
            return oldItem == newItem
        }


    }



}
