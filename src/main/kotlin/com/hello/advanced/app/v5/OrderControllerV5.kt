package com.hello.advanced.app.v5

import com.hello.advanced.trace.logtrace.LogTrace
import com.hello.advanced.trace.strategy.LogContext
import com.hello.advanced.trace.strategy.TraceStrategy
import jdk.jpackage.internal.Arguments.CLIOptions.context
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV5(
    private val orderServiceV5: OrderServiceV5,
    private val logTrace: LogTrace
) {

    @GetMapping("/v5/request")
    fun request(itemId: String): String {

        val value = object : TraceStrategy{
            override fun call() {
                orderServiceV5.orderItem(itemId)
            }
        }

        LogContext().execute(
            logStrategy = object : TraceStrategy {
                override fun call() {
                    orderServiceV5.orderItem(itemId)
                }
            }
        )

        LogContext().execute(
            logStrategy = object : TraceStrategy {
                override fun call() {
                    orderServiceV5.orderItem(itemId)
                }
            }
        )

        return "ok"
    }
}
