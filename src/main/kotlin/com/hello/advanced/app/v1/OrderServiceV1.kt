package com.hello.advanced.app.v1

import com.hello.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Service

@Service
class OrderServiceV1(
    private val orderRepositoryV1: OrderRepositoryV1,
    private val helloTraceV1: HelloTraceV1
) {

    fun orderItem(itemId: String){
        val trace = helloTraceV1.begin("OrderServiceV1.orderItem()")

        try {
            orderRepositoryV1.save(itemId)
            helloTraceV1.end(trace)
        } catch (e: Exception) {
            helloTraceV1.exception(trace, e)
            throw e
        }
    }

}
