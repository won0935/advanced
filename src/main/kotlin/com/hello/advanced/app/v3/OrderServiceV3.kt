package com.hello.advanced.app.v3

import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(
    private val orderRepositoryV3: OrderRepositoryV3,
    private val logTrace: LogTrace
) {

    fun orderItem(itemId: String) {
        val trace = logTrace.begin("OrderServiceV1.orderItem()")

        try {
            orderRepositoryV3.save(itemId)
            logTrace.end(trace)
        } catch (e: Exception) {
            logTrace.exception(trace, e)
            throw e
        }
    }

}
