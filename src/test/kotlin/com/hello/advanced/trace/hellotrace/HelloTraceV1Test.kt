package com.hello.advanced.trace.hellotrace

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class HelloTraceV1Test {

    @Test
    fun 로깅_시작_끝() {
        val trace = HelloTraceV1()
        val status = trace.begin("hello")
        trace.end(status)
    }

    @Test
    fun 로깅_예외() {
        val trace = HelloTraceV1()
        val status = trace.begin("hello")
        trace.exception(status, IllegalStateException())
    }

}
