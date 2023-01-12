package com.hello.advanced.trace.template.code

import mu.KLogger
import mu.KotlinLogging

interface TemplateSpec {

    val log: KLogger
        get() = KotlinLogging.logger { }

    fun execute() {
        val startTime = System.currentTimeMillis()
        call()
        val endTime = System.currentTimeMillis()
        log.info { "${this.javaClass.name} :: $startTime :: $endTime" }
    }

    fun call()
}
