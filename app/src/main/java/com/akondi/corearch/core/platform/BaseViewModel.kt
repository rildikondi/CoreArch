package com.akondi.corearch.core.platform

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.akondi.corearch.core.exception.Failure


/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */

abstract class BaseViewModel : ViewModel() {

     val failure: MutableState<Failure> = mutableStateOf(Failure())

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}