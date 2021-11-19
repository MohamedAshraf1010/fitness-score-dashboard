package com.app.creditscore.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.creditscore.presentation.loading.LoadingDialog

abstract class BaseActivity : AppCompatActivity()
{
    private lateinit var loading: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        loading = LoadingDialog(this)
    }

    fun showLoading()
    {
        if (!loading.isShowing) loading.show()
    }

    fun dismissLoading()
    {
        if (loading.isShowing) loading.dismiss()
    }
}