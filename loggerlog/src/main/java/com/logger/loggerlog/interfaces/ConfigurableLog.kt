package com.logger.loggerlog.interfaces

import com.google.gson.annotations.SerializedName
import com.logger.loggerlog.enums.LogMode

interface ConfigurableLog {
    @get:SerializedName("mode")
    var logMode: LogMode
    @get:SerializedName("level")
    var level: String
    @get:SerializedName("short_message")
    var message: String
    @get:SerializedName("platform")
    var platform: String
    @get:SerializedName("device")
    var device: String
    @get:SerializedName("appVersion")
    var appVersion: String
    @get:SerializedName("version")
    var oSVersion: String
    @get:SerializedName("hostUrl")
    var hostUrl : String

}