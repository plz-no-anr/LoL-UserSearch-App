package com.plznoanr.lol_usersearch_app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.plznoanr.lol_usersearch_app.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment: Fragment() {

    open fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }

    open fun initViews() {}

    open fun initObservers() {}

}