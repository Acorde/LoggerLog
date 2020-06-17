package com.logger.loggerlog.networking

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url

interface RestApi {

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST
    fun writeToLog(@Url url: String, @Body body: String): Call<ResponseBody?>

    @POST
    suspend fun getData(@Url url: String, @Body body: String): Call<ResponseBody?>

}