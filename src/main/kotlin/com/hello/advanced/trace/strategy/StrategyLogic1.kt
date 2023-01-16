package com.hello.advanced.trace.strategy

import mu.KotlinLogging

class StrategyLogic1 : TraceStrategy {

    private val log = KotlinLogging.logger {  }

    override fun call() {
        log.info { "비즈니스로직1 실행" }
    }
}
