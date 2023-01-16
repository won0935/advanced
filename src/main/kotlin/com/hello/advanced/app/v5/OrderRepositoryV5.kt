package com.hello.advanced.app.v5

import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository


@Repository
class OrderRepositoryV5(
    private val logTrace: LogTrace
) {

    fun save(itemId: String) {

        val trace = logTrace.begin("OrderRepositoryV1.save()")

        try {
            if (itemId == "ex")
                throw IllegalStateException("예외 발생!")

            sleep(1000)

            logTrace.end(trace)
        } catch (e: Exception) {
            logTrace.exception(trace, e)
            throw e
        }
    }

    private fun sleep(mills: Long) {
        try {
            Thread.sleep(mills)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
