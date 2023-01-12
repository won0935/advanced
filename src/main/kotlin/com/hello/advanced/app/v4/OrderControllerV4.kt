package com.hello.advanced.app.v3

import com.hello.advanced.trace.logtrace.LogTrace
import com.hello.advanced.trace.template.AbstractTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV4(
    private val orderServiceV3: OrderServiceV4,
    private val logTrace: LogTrace
) {

    @GetMapping("/v4/request")
    fun request(itemId: String): String {
        val template = object : AbstractTemplate<String>(logTrace){
            override fun call(): String {
                orderServiceV3.orderItem(itemId)
                return "ok"
            }
        }
        return template.execute("OrderControllerV4.request()")
    }
}
