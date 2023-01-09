package com.hello.advanced.trace.hellotrace

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class HelloTraceV2Test {

    @Test
    fun 로깅_시작_끝() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello1")
        val status2 = trace.beginSync(status1.traceId, "hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun 로깅_예외() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello1")
        val status2 = trace.beginSync(status1.traceId, "hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }

}
