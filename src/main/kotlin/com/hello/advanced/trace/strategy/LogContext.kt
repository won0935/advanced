package com.hello.advanced.trace.strategy

import mu.KotlinLogging

open class LogContext {

    private val log = KotlinLogging.logger { }

    fun execute(logStrategy: TraceStrategy) {
        val startTime = System.currentTimeMillis() //비즈니스 로직 실행
        logStrategy.call() //위임
        //비즈니스 로직 종료
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

}
