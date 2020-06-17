package com.logger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import com.logger.log.LogConfig
import com.logger.loggerlog.LoggerOld
import com.logger.loggerlog.enums.LogMode
import com.logger.loggerlog.enums.VenueType
import com.logger.loggerlog.interfaces.ConfigurableLog
import com.logger.loggerlog.loggers.NetworkLog


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

//            data class LoggerConfig(
//                override var logMode: LogMode,
//                override var level: String,
//                override var platform: String,
//                override var device: String,
//                override var appVersion: String,
//                override var oSVersion: String,
//                override var hostUrl: String,
//                override var message: String
//            ) : ConfigurableLog {}
//
//
//            val config = LoggerConfig(
//                LogMode.DEBUG,
//                "Level",
//                "Android",
//                "Android Device",
//                "1.32",
//                "Android O",
//                "http://51.105.232.93:12203/gelf",
//                "Log Message"
//            )


            val networkLog = NetworkLog(
                LogMode.DEBUG,
                System.currentTimeMillis().toString(),
                VenueType.Network,
                MainActivity::class.java.simpleName,
                "onCreate",
                "1234556",
                "154684646",
                "NetworkErrorTest"
            )

            var logger = LoggerOld.getInstance().initLogger(this, LogConfig())
            logger.logData(networkLog)


        }
    }
}
