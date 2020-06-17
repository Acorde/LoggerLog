package com.logger.loggerlog.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterCept: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)

        return response
    }
}