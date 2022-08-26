package com.letsgo.myapplicationtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var loadingDialog: LoadingDialog? = null

    fun showToast(message: String?) {
        if (!message.isNullOrEmpty()) {
            Toast.makeText(
                requireContext(),
                message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(requireContext())
        }

        if (loadingDialog?.isShowing == false) {
            loadingDialog?.show()
        }
    }

    fun dismissLoadingDialog() {
        loadingDialog?.dismiss()
    }
}