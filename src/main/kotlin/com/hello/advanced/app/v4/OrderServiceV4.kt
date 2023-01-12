package com.hello.advanced.app.v3

import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV4(
    private val orderRepositoryV4: OrderRepositoryV4,
    private val logTrace: LogTrace
) {

    fun orderItem(itemId: String) {
        val trace = logTrace.begin("OrderServiceV1.orderItem()")

        try {
            orderRepositoryV4.save(itemId)
            logTrace.end(trace)
        } catch (e: Exception) {
            logTrace.exception(trace, e)
            throw e
        }
    }

}
