package com.hello.advanced.trace.template.code

import mu.KLogger
import mu.KotlinLogging

abstract class AbstractTemplate {

    val log: KLogger
        get() = KotlinLogging.logger { }

    fun execute() {
        val startTime = System.currentTimeMillis()
        call()
        val endTime = System.currentTimeMillis()
        log.info { "${this.javaClass.name} :: $startTime :: $endTime" }
    }

    abstract  fun call()
}
