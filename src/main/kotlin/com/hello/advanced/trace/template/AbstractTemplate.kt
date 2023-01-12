package com.hello.advanced.trace.template

import com.hello.advanced.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(
    private val trace: LogTrace
) {

    fun execute(message: String): T {
        val status = trace.begin(message)
        try {
            val result = call()
            trace.end(status)
            return result
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

    abstract fun call(): T
}
