package com.hello.advanced.trace.template.code

class SubClass1 : TemplateSpec {
    override fun call() {
        log.info { "비즈니스 클래스1" }
    }
}
