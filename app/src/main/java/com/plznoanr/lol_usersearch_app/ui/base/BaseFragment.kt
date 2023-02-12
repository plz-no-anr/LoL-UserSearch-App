package com.plznoanr.lol_usersearch_app.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

open class BaseFragment: Fragment() {

    open fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }

}