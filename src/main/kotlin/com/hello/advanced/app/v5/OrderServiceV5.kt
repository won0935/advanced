package com.hello.advanced.app.v5

import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepositoryV5: OrderRepositoryV5,
    private val logTrace: LogTrace
) {

    fun orderItem(itemId: String) {
        val trace = logTrace.begin("OrderServiceV1.orderItem()")

        try {
            orderRepositoryV5.save(itemId)
            logTrace.end(trace)
        } catch (e: Exception) {
            logTrace.exception(trace, e)
            throw e
        }
    }

}
