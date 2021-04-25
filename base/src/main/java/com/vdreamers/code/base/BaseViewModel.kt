package com.vdreamers.code.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

typealias Block<T> = suspend () -> T
typealias Error = suspend (e: Exception) -> Unit
typealias Cancel = suspend (e: Exception) -> Unit

@Suppress("unused")
open class BaseViewModel : ViewModel() {

    /**
     * create coroutines and run
     *
     * @param block action in coroutines
     * @param error action in error
     * @return Job coroutines job
     */
    protected fun launch(block: Block<Unit>, error: Error? = null, cancel: Cancel? = null): Job {
        return viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> {
                        cancel?.invoke(e)
                    }
                    else -> {
                        val finalException = onPreError(e)
                        onError(finalException)
                        error?.invoke(finalException)
                    }
                }
            }
        }
    }

    /**
     * create coroutines and run async
     *
     * @param block action in coroutines
     * @return Deferred<T> coroutines deferred
     */
    protected fun <T> async(block: Block<T>): Deferred<T> {
        return viewModelScope.async { block.invoke() }
    }

    /**
     * 取消协程
     * @param job 协程job
     */
    protected fun cancelJob(job: Job?) {
        if (job != null && job.isActive && !job.isCompleted && !job.isCancelled) {
            job.cancel()
        }
    }

    /**
     * pre handle error
     *
     * @param e Exception original Exception
     * @return Exception final Exception
     */
    private fun onPreError(e: Exception): Exception {
        when (e) {
            is IOException -> {
                if (e is InterruptedException) {
                    return e
                }
            }
        }
        return e
    }

    /**
     * handle error
     *
     * @param e error
     */
    private fun onError(e: Exception) {
        when (e) {
            is ConnectException -> {
            }
            is SocketTimeoutException -> {
            }
            else -> {
            }
        }
    }
}