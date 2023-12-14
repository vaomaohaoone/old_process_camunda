package org.sample.home.camunda.delegate

import org.apache.logging.log4j.kotlin.Logging
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.sample.home.camunda.SEND_NOTIFICATION_DELEGATE
import org.springframework.stereotype.Component

@Component(SEND_NOTIFICATION_DELEGATE)
class SendNotificationDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val busKey = execution.businessKey
        logger.info("SendNotificationDelegate: $busKey")
    }

    companion object : Logging

}