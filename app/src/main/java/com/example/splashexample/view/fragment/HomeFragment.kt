package com.example.splashexample.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splashexample.R
import com.example.splashexample.adapter.UnsplashAdapter
import com.example.splashexample.databinding.FragmentHomeBinding
import com.example.splashexample.utils.snackBar
import com.example.splashexample.utils.toast
import com.example.splashexample.viewmodel.UnsplashViewModel
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : UnsplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        viewModel = ViewModelProvider(this).get(UnsplashViewModel::class.java)


        binding.unsplashShimmer.visibility = View.VISIBLE
        viewModel.getphotos().observe(viewLifecycleOwner) {
            binding.splashRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                binding.unsplashShimmer.visibility = View.GONE
                adapter = UnsplashAdapter(requireView(),it)
            }
        }

        viewModel.errorResponse.observe(viewLifecycleOwner) {
            requireContext().toast(it.errors)
        }


        binding.unsplashRefresh.setOnRefreshListener {

            requireContext().toast("Refreshed")
            viewModel.getphotos()
            binding.unsplashRefresh.isRefreshing  = false

        }


        return binding.root

    }

}