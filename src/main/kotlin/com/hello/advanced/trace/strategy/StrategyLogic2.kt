package com.hello.advanced.trace.strategy

import mu.KotlinLogging

class StrategyLogic2 : TraceStrategy {

    private val log = KotlinLogging.logger {  }

    override fun call() {
        log.info { "비즈니스로직2 실행" }
    }
}
