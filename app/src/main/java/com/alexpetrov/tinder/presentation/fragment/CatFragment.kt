package com.alexpetrov.tinder.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexpetrov.tinder.R
import com.alexpetrov.tinder.databinding.FragmentFavoriteBinding
import com.alexpetrov.tinder.presentation.adapter.CatAdapter
import com.alexpetrov.tinder.presentation.utils.AppState
import com.alexpetrov.tinder.presentation.viewmodel.CatViewModel


class CatFragment : Fragment
    (R.layout.fragment_favorite) {

    private lateinit var binding: FragmentFavoriteBinding
    private val adapter: CatAdapter by lazy { CatAdapter() }

    private val viewModel: CatViewModel by lazy {
        ViewModelProvider(this)[CatViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)
        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getData()
    }

    private fun renderData(appState: AppState) {
        if (appState is AppState.SuccessFavorite) {
            if (appState.favoriteData.isNotEmpty())
                adapter.setData(appState.favoriteData)
            else
                Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
        }
        else if (appState is AppState.Error) {
            Toast.makeText(context, appState.e.message, Toast.LENGTH_SHORT).show()
        }
    }
}