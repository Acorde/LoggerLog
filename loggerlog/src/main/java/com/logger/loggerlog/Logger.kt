package com.logger.loggerlog

import com.logger.loggerlog.interfaces.BaseLog
import com.logger.loggerlog.interfaces.ConfigurableLog
import com.logger.loggerlog.networking.NetworkRepository
import com.logger.loggerlog.networking.NetworkResponse

class Logger {

    companion object {
        fun <T : ConfigurableLog, B : BaseLog> send(logMessage: LogMessage<T, B>) {





//            NetworkRepository.getInstance().sendLog(logMessage, object : NetworkResponse<Any?> {
//                override fun onSuccess(data: Any?) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onError(data: Any?) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onFailure(data: Any?) {
//                    TODO("Not yet implemented")
//                }
//            })

        }


    }


}