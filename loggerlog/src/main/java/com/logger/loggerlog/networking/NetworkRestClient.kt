package com.logger.loggerlog.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class NetworkRestClient {




    companion object {
        private const val TIME_OUT: Long = 200000
        val BASE_URL = ""

        var interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply { this.setLevel(HttpLoggingInterceptor.Level.BODY) }

       private val okHttpClient =
            OkHttpClient.Builder().connectTimeout(TIME_OUT, TimeUnit.MICROSECONDS).addInterceptor(
                interceptor)
            .build()

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.foo.com/")
            .client(okHttpClient)
            .build()

        val client = retrofit.create(RestApi::class.java)

    }


}