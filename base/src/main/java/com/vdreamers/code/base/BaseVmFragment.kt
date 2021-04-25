package com.vdreamers.code.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

@Suppress("unused")
abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {

    protected lateinit var mViewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        observe()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(viewModelClass())
    }

    abstract fun viewModelClass(): Class<VM>

    open fun initView() {
        // Override if need
    }

    open fun observe() {

    }

    open fun initData() {
        // Override if need
    }
}
