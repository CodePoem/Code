package com.vdreamers.code.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView()
    }

    open fun initContentView() {
        setContentView(layoutRes())
    }

    open fun layoutRes() = 0

}
