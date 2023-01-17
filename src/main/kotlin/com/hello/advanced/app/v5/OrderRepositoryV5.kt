package com.hello.advanced.app.v5

import com.hello.advanced.trace.callback.TraceCallback
import com.hello.advanced.trace.callback.TraceTemplate
import com.hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository


@Repository
class OrderRepositoryV5(
    private val logTrace: LogTrace
) {
    private val traceTemplate: TraceTemplate = TraceTemplate(logTrace)

    fun save(itemId: String) {
        traceTemplate.execute("OrderRepository.save()", object : TraceCallback<String> {
            override fun call(): String {
                check(itemId != "ex") { "예외 발생!" }
                sleep(1000)
                return "ok"
            }
        })
    }

    private fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
