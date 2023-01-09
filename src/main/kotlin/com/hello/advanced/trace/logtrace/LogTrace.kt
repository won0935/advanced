package com.hello.advanced.trace.logtrace

import com.hello.advanced.trace.TraceStatus
import java.lang.Exception

interface LogTrace {

    fun begin (message : String) : TraceStatus

    fun end (traceStatus: TraceStatus)

    fun exception(traceStatus: TraceStatus, exception: Exception)

}
