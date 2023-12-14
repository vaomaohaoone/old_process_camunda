package org.sample.home.camunda

import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl
import org.camunda.bpm.engine.runtime.Incident
import org.camunda.bpm.spring.boot.starter.configuration.Ordering
import org.camunda.bpm.spring.boot.starter.util.SpringBootProcessEnginePlugin
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(Ordering.DEFAULT_ORDER + 1)
class IncidentPlugin : SpringBootProcessEnginePlugin() {

    override fun preInit(processEngineConfiguration: ProcessEngineConfigurationImpl) {
        processEngineConfiguration.customIncidentHandlers = listOf(
            Incident.FAILED_JOB_HANDLER_TYPE, Incident.EXTERNAL_TASK_HANDLER_TYPE
        ).map { CustomIncidentHandler(it) }
    }

}