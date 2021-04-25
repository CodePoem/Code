package com.vdreamers.code.base

import androidx.viewbinding.ViewBinding

abstract class BaseVbVmActivity<VB : ViewBinding, VM : BaseViewModel> : BaseVmActivity<VM>() {

    protected open lateinit var mBinding: VB

    override fun initContentView() {
        mBinding = viewBindingInflate()
        setContentView(mBinding.root)
    }

    protected abstract fun viewBindingInflate(): VB
}
