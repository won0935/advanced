package com.hello.advanced.app.v2

import com.hello.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV2(
    private val orderServiceV2: OrderServiceV2,
    private val helloTraceV2: HelloTraceV2
) {

    @GetMapping("/v2/request")
    fun request(itemId: String): String {
        val trace = helloTraceV2.begin("OrderControllerV1.request()")

        try {
            orderServiceV2.orderItem(trace.traceId, itemId)
            helloTraceV2.end(trace)
        } catch (e: Exception) {
            helloTraceV2.exception(trace, e)
            throw e
        }
        return "ok"
    }

}
