package com.hello.advanced.app.v1

import com.hello.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV1(
    private val orderServiceV1: OrderServiceV1,
    private val helloTraceV1: HelloTraceV1
) {

    @GetMapping("/v1/request")
    fun request(itemId: String): String {
        val trace = helloTraceV1.begin("OrderControllerV1.request()")

        try {
            orderServiceV1.orderItem(itemId)
            helloTraceV1.end(trace)
        } catch (e: Exception) {
            helloTraceV1.exception(trace, e)
            throw e
        }
        return "ok"
    }

}
