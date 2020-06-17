package com.logger.loggerlog.networking

interface NetworkResponse<T> {

    fun onSuccess(data: T)

    fun onError(data: T)

    fun onFailure(data: T)

}