package com.vdreamers.code.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

@Suppress("unused")
abstract class BaseVbVmFragment<VB : ViewBinding, VM : BaseViewModel> : BaseVmFragment<VM>() {

    protected lateinit var mBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = viewBindingInflate()
        return mBinding.root
    }

    protected abstract fun viewBindingInflate(): VB
}
