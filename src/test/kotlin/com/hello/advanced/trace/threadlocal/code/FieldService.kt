package com.hello.advanced.trace.threadlocal.code

import mu.KotlinLogging

class FieldService {
    var nameStore: String = ""

    private val log = KotlinLogging.logger { }

    fun logic(name: String): String {

        log.info { "저장 name = $name -> nameStore = $nameStore" }

        nameStore = name
        Thread.sleep(1000)

        log.info { "조회 nameStore = $nameStore" }
        return nameStore

    }

}
