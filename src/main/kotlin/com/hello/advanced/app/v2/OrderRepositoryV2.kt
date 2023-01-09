package com.hello.advanced.app.v2

import com.hello.advanced.trace.TraceId
import com.hello.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Repository


@Repository
class OrderRepositoryV2(
    private val helloTraceV2: HelloTraceV2
) {

    fun save(traceId: TraceId, itemId: String) {

        val trace = helloTraceV2.beginSync(traceId, "OrderRepositoryV1.save()")

        try {
            if (itemId == "ex")
                throw IllegalStateException("예외 발생!")

            sleep(1000)

            helloTraceV2.end(trace)
        } catch (e: Exception) {
            helloTraceV2.exception(trace, e)
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
