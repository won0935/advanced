package com.hello.advanced.app.v2

import com.hello.advanced.trace.TraceId
import com.hello.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Service

@Service
class OrderServiceV2(
    private val orderRepositoryV2: OrderRepositoryV2,
    private val helloTraceV2: HelloTraceV2
) {

    fun orderItem(traceId : TraceId, itemId: String) {
        val trace = helloTraceV2.beginSync(traceId, "OrderServiceV1.orderItem()")

        try {
            orderRepositoryV2.save(trace.traceId, itemId)
            helloTraceV2.end(trace)
        } catch (e: Exception) {
            helloTraceV2.exception(trace, e)
            throw e
        }
    }

}
