package org.sample.home.camunda.delegate

import org.apache.logging.log4j.kotlin.Logging
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.sample.home.camunda.CHANGE_STATUS_DELEGATE
import org.springframework.stereotype.Component

@Component(CHANGE_STATUS_DELEGATE)
class ChangeStatusDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val busKey = execution.businessKey
        logger.info("ChangeStatusDelegate: $busKey" )
    }

    companion object: Logging

}