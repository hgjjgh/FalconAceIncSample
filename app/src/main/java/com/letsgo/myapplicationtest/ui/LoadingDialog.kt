package com.letsgo.myapplicationtest.ui

import android.app.Dialog
import android.content.Context
import com.letsgo.myapplicationtest.R

class LoadingDialog(context: Context) : Dialog(context, R.style.dialog_loading) {
    init {
        setCancelable(false)
        setContentView(R.layout.loading_dialog)
    }
}