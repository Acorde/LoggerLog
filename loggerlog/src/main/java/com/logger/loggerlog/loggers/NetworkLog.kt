package com.logger.loggerlog.loggers


import com.logger.loggerlog.enums.LogMode
import com.logger.loggerlog.enums.VenueType
import com.logger.loggerlog.interfaces.BaseLog

class NetworkLog(
    override var logLevel: LogMode,
    override var logTimeStamp: String,
    override var venueType: VenueType,
    override var className: String,
    override var methodName: String,
    override var userId: String?,
    override var uId: String?,
    override var message: String
) : BaseLog {


//    override fun sendLog() {
//        LoggerOld.getInstance().logData(this)
//    }
}