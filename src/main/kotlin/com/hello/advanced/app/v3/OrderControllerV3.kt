package com.hello.advanced.app.v3

import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV3(
    private val orderServiceV3: OrderServiceV3,
    private val logTrace: LogTrace
) {

    @GetMapping("/v3/request")
    fun request(itemId: String): String {
        val trace = logTrace.begin("OrderControllerV1.request()")

        try {
            orderServiceV3.orderItem(itemId)
            logTrace.end(trace)
        } catch (e: Exception) {
            logTrace.exception(trace, e)
            throw e
        }
        return "ok"
    }

}
