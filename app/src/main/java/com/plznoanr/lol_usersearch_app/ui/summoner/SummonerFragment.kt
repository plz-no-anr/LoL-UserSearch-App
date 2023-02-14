package com.plznoanr.lol_usersearch_app.ui.summoner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plznoanr.lol_usersearch_app.R
import com.plznoanr.lol_usersearch_app.databinding.FragmentSpectatorBinding
import com.plznoanr.lol_usersearch_app.databinding.FragmentSummonerBinding


class SummonerFragment : Fragment() {
    private var _binding: FragmentSummonerBinding? = null
    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() =
            SummonerFragment().apply {
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
    ): View = FragmentSummonerBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}