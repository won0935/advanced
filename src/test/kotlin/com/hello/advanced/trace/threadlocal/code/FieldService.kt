package com.hello.advanced.trace.threadlocal.code

import mu.KotlinLogging

class FieldService {
    var nameStore: String = ""

    private val log = KotlinLogging.logger { }

    fun logic(name: String): String {

        log.info { "์ ์ฅ name = $name -> nameStore = $nameStore" }

        nameStore = name
        Thread.sleep(1000)

        log.info { "์กฐํ nameStore = $nameStore" }
        return nameStore

    }

}
