package com.hello.advanced.trace.logtrace

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class FieldLogTraceTest {

    val trace = FieldLogTrace()

    @Test
    fun 로깅_시작_끝() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun 로깅_예외() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }

}
