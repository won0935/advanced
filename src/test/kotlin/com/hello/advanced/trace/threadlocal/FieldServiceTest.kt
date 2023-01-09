package com.hello.advanced.trace.threadlocal

import com.hello.advanced.trace.threadlocal.code.FieldService
import mu.KotlinLogging
import org.junit.jupiter.api.Test

class FieldServiceTest(
) {

    private val fieldService: FieldService = FieldService()
    private val log = KotlinLogging.logger {  }

    @Test
    fun field(){
        log.info { "main start" }

        val userA = Runnable { fieldService.logic("userA") }
        val userB = Runnable { fieldService.logic("userB") }

        val threadA = Thread(userA)
        threadA.name = "thread-A"
        val threadB = Thread(userB)
        threadB.name = "thread-B"
        threadA.start() //A실행 sleep(2000); //동시성 문제 발생X

        Thread.sleep(100) //동시성 문제 발생O threadB.start(); //B실행

        Thread.sleep(3000) //메인 쓰레드 종료 대기

        log.info("main exit")
    }
}
