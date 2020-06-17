package com.logger.loggerlog.networking

import okhttp3.Interceptor
import okhttp3.Response

class DefauldParamsInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val ongoing = chain.request().newBuilder()

        ongoing.addHeader("Content-Type", "application/json;charset=utf-8")


            return chain.proceed(chain.request())
    }
}