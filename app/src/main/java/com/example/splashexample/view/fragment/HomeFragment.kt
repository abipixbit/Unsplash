package com.example.splashexample.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splashexample.adapter.PagingAdapter
import com.example.splashexample.databinding.FragmentHomeBinding
import com.example.splashexample.model.network.APIInterface
import com.example.splashexample.viewmodel.UnsplashViewModel
import com.example.splashexample.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : UnsplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        viewModel = ViewModelProvider(this,ViewModelFactory(APIInterface.getApi()))[UnsplashViewModel::class.java]


        val newAdapter = PagingAdapter(requireContext())

        lifecycleScope.launch {
            viewModel.unsplash.collect {
                newAdapter.submitData(it)
            }
        }


        binding.splashRecyclerView.apply {
            binding.unsplashShimmer.stopShimmer()
            binding.unsplashShimmer.visibility = View.GONE
            adapter = newAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }

        return binding.root

    }

}