package com.letsgo.myapplicationtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.letsgo.myapplicationtest.databinding.MainFragmentBinding
import com.letsgo.myapplicationtest.network.repository.NewsRepository
import com.letsgo.myapplicationtest.ui.adapter.NewsAdapter
import com.letsgo.myapplicationtest.viewmodel.MainViewModel
import com.letsgo.myapplicationtest.viewmodel.factory.BaseViewModelFactory

class MainFragment : BaseFragment() {
    private lateinit var binding: MainFragmentBinding
    private val mainViewModel: MainViewModel by lazy {
        val factory = BaseViewModelFactory(
            MainViewModel(NewsRepository())
        )
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
        mainViewModel.getNewsList()
    }

    private fun observeEvent() {
        mainViewModel.apply {
            apiErrorMessage.observe(viewLifecycleOwner) {
                showToast(it)
            }

            showLoading.observe(viewLifecycleOwner) { showLoading ->
                if (showLoading) {
                    showLoadingDialog()
                } else {
                    dismissLoadingDialog()
                }
            }

            newsList.observe(viewLifecycleOwner) {
                binding.newsRecyclerView.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = NewsAdapter(it)
                }
            }
        }
    }
}