package com.logger.log

import com.logger.loggerlog.enums.LogMode
import com.logger.loggerlog.interfaces.ConfigurableLog

class LogConfig() : ConfigurableLog {
    override var logMode: LogMode = LogMode.DEBUG

    override var platform: String = "Android"

    override var message: String = "Message"

    override var level: String = "level1"

    override var device: String =
        android.os.Build.MANUFACTURER.plus(" ").plus(android.os.Build.MODEL)

    override var appVersion: String = "1.1"

    override var oSVersion: String = "9"

    // override var hostUrl: String = "http://51.105.232.93:12203/gelf"
    override var hostUrl: String = "http://51.105.232.93:12201/gelf"


}