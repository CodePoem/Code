package com.vdreamers.code.main.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.vdreamers.code.base.BaseVbVmActivity
import com.vdreamers.code.databinding.CdaActivityMainBinding
import com.vdreamers.code.main.viewmodle.MainViewModel

class MainActivity : BaseVbVmActivity<CdaActivityMainBinding, MainViewModel>() {


    override fun viewBindingInflate(): CdaActivityMainBinding =
        CdaActivityMainBinding.inflate(layoutInflater)

    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            val args = Bundle()
            intent.putExtras(args)
            context.startActivity(intent)
        }
    }

}