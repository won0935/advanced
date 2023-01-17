package com.hello.advanced.app.v5

import com.hello.advanced.trace.callback.TraceCallback
import com.hello.advanced.trace.callback.TraceTemplate
import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepository: OrderRepositoryV5,
    private val logTrace: LogTrace
) {
    private val traceTemplate: TraceTemplate = TraceTemplate(logTrace)

    fun orderItem(itemId: String): String {
        return traceTemplate.execute("orderRepository.request()", object : TraceCallback<String> {
            override fun call(): String {
                orderRepository.save(itemId)
                return "ok"
            }
        })
    }

}
