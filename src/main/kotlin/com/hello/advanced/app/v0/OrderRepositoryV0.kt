package com.hello.advanced.app.v0

import org.springframework.stereotype.Repository
import java.lang.IllegalStateException


@Repository
class OrderRepositoryV0 {

    fun save(itemId : String){

        if(itemId == "ex")
            throw IllegalStateException("예외 발생!")

        sleep(1000)

    }

    private fun sleep(mills : Long){
        try {
            Thread.sleep(mills)
        } catch (e : InterruptedException){
            e.printStackTrace()
        }
    }


}
