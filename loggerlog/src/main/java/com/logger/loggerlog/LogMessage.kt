package com.logger.loggerlog

import com.logger.loggerlog.interfaces.BaseLog
import com.logger.loggerlog.interfaces.ConfigurableLog

class LogMessage<T : ConfigurableLog, B : BaseLog>(val config: T, val baseLog: B) {}