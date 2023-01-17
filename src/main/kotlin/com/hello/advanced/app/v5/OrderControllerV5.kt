package com.hello.advanced.app.v5

import com.hello.advanced.trace.callback.TraceCallback
import com.hello.advanced.trace.callback.TraceTemplate
import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV5(
    private val orderService: OrderServiceV5,
    private val logTrace: LogTrace
) {
    private val traceTemplate: TraceTemplate = TraceTemplate(logTrace)

    @GetMapping("/v5/request")
    fun request(itemId: String): String {

        return traceTemplate.execute("OrderController.request()", object : TraceCallback<String> {
            override fun call(): String {
                orderService.orderItem(itemId)
                return "ok"
            }
        })
    }
}
