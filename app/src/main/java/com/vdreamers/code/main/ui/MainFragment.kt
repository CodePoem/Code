package com.vdreamers.code.main.ui

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vdreamers.code.base.BaseVbVmFragment
import com.vdreamers.code.databinding.CdaFragmentMainBinding
import com.vdreamers.code.main.viewmodle.MainViewModel

class MainFragment : BaseVbVmFragment<CdaFragmentMainBinding, MainViewModel>() {
    override fun viewBindingInflate(container: ViewGroup?): CdaFragmentMainBinding =
        CdaFragmentMainBinding.inflate(layoutInflater, container, false)

    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initView() {
        super.initView()
        mBinding.tvHello.setText("Hello Code~")
    }
}