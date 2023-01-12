package com.hello.advanced.trace.template

import com.hello.advanced.trace.template.code.AbstractTemplate
import com.hello.advanced.trace.template.code.SubClass1
import com.hello.advanced.trace.template.code.SubClass2
import org.junit.jupiter.api.Test


class TemplateMethodTest {

    private val subClass1 = SubClass1()
    private val subClass2 = SubClass2()

    @Test
    fun 템플릿메소드() {
        subClass1.execute()
        subClass2.execute()
    }

    @Test
    fun 익명내부_클래스() {
        val template: AbstractTemplate = object : AbstractTemplate() {
            override fun call() {
                log.info { "익명내부 클래스" }
            }
        }
    }
}
