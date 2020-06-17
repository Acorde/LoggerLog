package com.logger.loggerlog

import android.content.Context
import com.facebook.stetho.Stetho
import com.google.gson.Gson
import com.logger.loggerlog.interfaces.BaseLog
import com.logger.loggerlog.interfaces.ConfigurableLog
import com.logger.loggerlog.networking.NetworkRepository
import com.logger.loggerlog.networking.NetworkResponse
import com.logger.loggerlog.utils.SharedPref
import com.logger.loggerlog.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import org.json.JSONObject

class LoggerOld private constructor() {

    private var config: ConfigurableLog? = null


    companion object {

        private var mContext: Context? = null

        private var instance: LoggerOld? = null


        fun getInstance(): LoggerOld {
            if (instance == null) {
                instance = LoggerOld()
            }
            return instance!!
        }
    }


    fun initLogger(context: Context, config: ConfigurableLog): LoggerOld {
        mContext = context
        Stetho.initializeWithDefaults(mContext)
        this.config = config
        SharedPref.init(context)

        return this
    }



    fun logData(data: BaseLog) {
        if (config == null || mContext == null) {
            throw IllegalStateException("You must initialize the Logger")
        } else {
            if (data.logLevel.ordinal >= config!!.logMode.ordinal) {

                val combinedData = Utils.getCombineObject(data, config!!)
                //Save data to shared pref
                data.logTimeStamp.apply {
                    SharedPref.getInstance().addNewData(this, combinedData, "")
                }
                NetworkRepository.getInstance().sendLog(combinedData, config!!.hostUrl, object : NetworkResponse<Any?> {
                        override fun onSuccess(data: Any?) {
//                            JSONObject(data.toString()).getString("timeStamp")?.let {
//                                SharedPref.getInstance().deleteValue(it)
//                            }
                        var x = ""
                        }

                        override fun onError(data: Any?) {

                        }

                        override fun onFailure(data: Any?) {

                        }
                    })

            }
        }
    }
}