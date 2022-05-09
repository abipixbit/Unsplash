package com.example.splashexample.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.splashexample.R
import com.google.android.material.snackbar.Snackbar

fun Context.glider(url : String, imageView: ImageView) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.unsplash)
        .into(imageView)
}

fun View.snackBar(message : String) {
    Snackbar.make(this,message,Snackbar.LENGTH_SHORT).show()
}

fun Context.toast(input : String) {
    Toast.makeText(this,input,Toast.LENGTH_SHORT).show()
}