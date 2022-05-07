package com.example.splashexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splashexample.databinding.UnsplashSingleScreenBinding
import com.example.splashexample.model.data.UnsplashDataResponse
import com.example.splashexample.utils.glider

class UnsplashAdapter(val view: View, val unsplashData : List<UnsplashDataResponse.UnsplashDataResponseItem>) : RecyclerView.Adapter<UnsplashAdapter.ViewHolder>() {


    class ViewHolder(val binding: UnsplashSingleScreenBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsplashAdapter.ViewHolder {
        return ViewHolder(UnsplashSingleScreenBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UnsplashAdapter.ViewHolder, position: Int) {

        val currentItem = unsplashData[position]

        holder.binding.nameText.text = currentItem.description
        holder.binding.likeCOuntText.text = currentItem.likes.toString()
        view.glider(currentItem.urls.regular, holder.binding.unsplashSingleImage)
    }

    override fun getItemCount(): Int {
        return unsplashData.size
    }


}