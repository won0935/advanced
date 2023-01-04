package com.hello.advanced.trace.hellotrace

import com.hello.advanced.trace.TraceId
import com.hello.advanced.trace.TraceStatus
import mu.KotlinLogging
import org.springframework.stereotype.Component


@Component
class HelloTraceV1 {
    private val log = KotlinLogging.logger {}

    companion object {
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X-"
    }

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startMills = System.currentTimeMillis()
        log.info(
            "[{}] {}{}", traceId.id, addSpace(
                START_PREFIX,
                traceId.level
            ), message
        );

        return TraceStatus(
            traceId = traceId, startTimeMs = startMills, message = message
        )
    }

    fun end(status: TraceStatus) {
        complete(status, null)
    }

    fun exception(status: TraceStatus, exception: Exception) {
        complete(status, exception)
    }

    private fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs: Long = stopTimeMs - status.startTimeMs
        val (id, level) = status.traceId
        if (e == null) {
            log.info(
                "[{}] {}{} time={}ms", id,
                addSpace(COMPLETE_PREFIX, level), status.message,
                resultTimeMs
            )
        } else {
            log.info(
                "[{}] {}{} time={}ms ex={}", id,
                addSpace(EX_PREFIX, level), status.message, resultTimeMs,
                e.toString()
            )
        }

    }

    private fun addSpace(prefix: String, level: Long): String {
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append(if (i == level - 1) "|$prefix" else "|   ")
        }
        return sb.toString()
    }

}
