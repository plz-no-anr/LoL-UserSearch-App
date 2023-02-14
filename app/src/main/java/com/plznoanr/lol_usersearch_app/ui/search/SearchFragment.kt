package com.plznoanr.lol_usersearch_app.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.plznoanr.lol_usersearch_app.databinding.FragmentSearchBinding
import com.plznoanr.lol_usersearch_app.itemSearch
import com.plznoanr.lol_usersearch_app.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseFragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSearchBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initViews() {
        with(binding) {
            ivSearch.setOnClickListener {
//                navigateTo(R.id.action_global_summonerFragment)
                etSearch.text.toString().let {
                    viewModel.insertSearch(it)
                }
            }
            tvAllDelete.setOnClickListener {
                viewModel.deleteAll()
            }
            ervSearchList.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext()).apply {
                    reverseLayout = true
                    stackFromEnd = true
                }
            }

        }
    }

    override fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collectLatest { state ->
                when {
                    state.isLoading -> {
                        Timber.d("Loading")
                    }
                    state.isError -> {
                        Timber.d("Error")
                    }
                    else -> {
                        state.data?.let {
                            Timber.d("DataLoaded")
                            binding.ervSearchList.withModels {
                                it.forEachIndexed { index, search ->
                                    itemSearch {
                                        id(index)
                                        item(search)
                                        onRemoveClick { _ ->
                                            search.uid?.let { uid -> viewModel.deleteSearch(uid) }
                                        }
                                    }
                                }
                            }
                            binding.ervSearchList.requestModelBuild()
                        }
                    }
                }
            }
        }
        viewModel.effect.onEach { effect ->
            when (effect) {
                is SearchEffect.Save.Success -> {
                    Toast.makeText(requireContext(), "SaveSuccess", Toast.LENGTH_SHORT).show()
                }
                is SearchEffect.Save.Failed -> {
                    val errMsg = effect.errMsg ?: "SaveFailed"
                    Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
                }
                is SearchEffect.Delete.Success -> {
                    Toast.makeText(requireContext(), "DeleteSuccess", Toast.LENGTH_SHORT).show()
                }
                is SearchEffect.Delete.Failed -> {
                    val errMsg = effect.errMsg ?: "DeleteFailed"
                    Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.setEvent(SearchEvent.Refresh)
        }.launchIn(lifecycleScope)
    }


}