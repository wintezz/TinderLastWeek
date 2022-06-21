package com.alexpetrov.tinder.presentation.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alexpetrov.tinder.R
import com.alexpetrov.tinder.data.dto.ImageResponce
import com.alexpetrov.tinder.data.dto.MessageResponce
import com.alexpetrov.tinder.data.dto.VoteRequest
import com.alexpetrov.tinder.databinding.FragmentMainBinding
import com.alexpetrov.tinder.presentation.utils.AppState
import com.alexpetrov.tinder.presentation.viewmodel.MainViewModel

class MainFragment : Fragment
    (R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var post: ImageResponce

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initViewModel()
        buttonClick()
    }

    private fun buttonClick() {
        binding.cardLike.setOnClickListener {
            viewModel.postVote(createBody(LIKE))
            viewModel.saveFavorite(post)
            viewModel.getData()
        }

        binding.cardDislike.setOnClickListener {
            viewModel.postVote(createBody(DISLIKE))
            viewModel.getData()
        }
    }

    private fun createBody(params: Int): VoteRequest {
        return VoteRequest(
            post.id,
            SUB_ID,
            params
        )
    }

    private fun initViewModel() {
        viewModel = MainViewModel()
        viewModel.liveDataPost.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.liveDataVote.observe(viewLifecycleOwner) { showToast(it) }
        viewModel.getData()
    }

    private fun showToast(messageRequest: MessageResponce) {
        Log.d("POST", messageRequest.message)
    }

    private fun renderData(appState: AppState) {
        if (appState is AppState.SuccessMain) {
            post = appState.imageResponse[FIRST]
            val uri = Uri.parse(post.url)
            binding.image.setImageURI(uri)
        }
        else if (appState is AppState.Error) {
            Toast.makeText(context, appState.e.message, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val FIRST = 0
        private const val SUB_ID = "from-phone"
        private const val LIKE = 1
        private const val DISLIKE = 0
    }
}