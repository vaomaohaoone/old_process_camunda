package org.sample.home.service

import org.apache.commons.lang3.RandomStringUtils
import org.camunda.bpm.engine.RuntimeService
import org.sample.home.camunda.PROCESS_ID
import org.springframework.stereotype.Service

@Service
class ProcessService(
    private val runtimeService: RuntimeService
) {

    fun startProcess() {
        val businessKey = "BUSINESS_KEY_${RandomStringUtils.randomNumeric(100)}"
        runtimeService.startProcessInstanceByKey(
            PROCESS_ID, businessKey
        )
    }

}