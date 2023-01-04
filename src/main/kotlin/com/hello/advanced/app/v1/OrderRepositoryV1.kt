package com.hello.advanced.app.v1

import com.hello.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Repository


@Repository
class OrderRepositoryV1(private val helloTraceV1: HelloTraceV1) {

    fun save(itemId: String) {

        val trace = helloTraceV1.begin("OrderRepositoryV1.save()")

        try {
            if (itemId == "ex")
                throw IllegalStateException("예외 발생!")

            sleep(1000)

            helloTraceV1.end(trace)
        } catch (e: Exception) {
            helloTraceV1.exception(trace, e)
            throw e
        }
    }

    private fun sleep(mills: Long) {
        try {
            Thread.sleep(mills)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
