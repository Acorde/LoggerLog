package com.logger.loggerlog.networking


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class NetworkRepository private constructor() {


    companion object {

        private var instance: NetworkRepository? = null

        fun getInstance(): NetworkRepository {
            if (instance == null) {
                instance =
                    NetworkRepository()
            }
            return instance!!
        }
    }


    fun sendLog(combinedData: String, hostUrl: String, networkResponse: NetworkResponse<Any?>) {
        try {

           // var x = "{className:AppActivity,logLevel:DEBUG,logTimeStamp:1591790361823,message:NetworkErrorTest,methodName:onCreate,uId:154684646,userId:1234556,venueType:Network,appVersion:0.1,device:Google Android SDK built for x86,hostUrl:http://51.105.232.93:12203/gelf,logMode:DEBUG,oSVersion:9,platform:Android}"


            val call = NetworkRestClient.client.writeToLog(hostUrl, combinedData)

            call.enqueue(object : Callback<ResponseBody?> {
                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    if (response.isSuccessful) {
                        networkResponse.onSuccess(combinedData)
                    }
                }

            })
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }




    suspend fun sendCoroutineLog(combinedData: String, hostUrl: String, networkResponse: NetworkResponse<Any?>){


    }


}