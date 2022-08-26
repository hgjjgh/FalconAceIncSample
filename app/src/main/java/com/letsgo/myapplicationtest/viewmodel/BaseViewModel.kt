package com.letsgo.myapplicationtest.viewmodel

import androidx.lifecycle.ViewModel
import com.letsgo.myapplicationtest.common.SingleLiveEvent

open class BaseViewModel : ViewModel() {
    val apiErrorMessage = SingleLiveEvent<String?>()
    val showLoading = SingleLiveEvent<Boolean>()
}