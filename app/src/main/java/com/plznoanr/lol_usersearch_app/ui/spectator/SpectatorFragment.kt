package com.plznoanr.lol_usersearch_app.ui.spectator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plznoanr.lol_usersearch_app.R
import com.plznoanr.lol_usersearch_app.databinding.FragmentSearchBinding
import com.plznoanr.lol_usersearch_app.databinding.FragmentSpectatorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpectatorFragment : Fragment() {
    private var _binding: FragmentSpectatorBinding? = null
    private val binding get() = _binding!!
    companion object {

        @JvmStatic
        fun newInstance() =
            SpectatorFragment().apply {
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
    ): View = FragmentSpectatorBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initViews() {
        with(binding) {
        }
    }

}