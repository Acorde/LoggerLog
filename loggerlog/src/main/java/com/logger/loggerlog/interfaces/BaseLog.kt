package com.logger.loggerlog.interfaces

import com.google.gson.annotations.SerializedName
import com.logger.loggerlog.enums.LogMode
import com.logger.loggerlog.enums.VenueType

interface BaseLog {

    @get:SerializedName("logLevel")
    var logLevel: LogMode
    @get:SerializedName("logTimeStamp")
    var logTimeStamp: String
    @get:SerializedName("type")
    var venueType: VenueType
    @get:SerializedName("className")
    var className: String
    @get:SerializedName("methodName")
    var methodName: String
    @get:SerializedName("userId")
    var userId: String?
    @get:SerializedName("uid")
    var uId: String?
    @get:SerializedName("message")
    var message: String
}