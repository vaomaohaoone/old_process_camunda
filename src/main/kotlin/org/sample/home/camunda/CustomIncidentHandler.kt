package org.sample.home.camunda

import org.camunda.bpm.engine.impl.incident.DefaultIncidentHandler
import org.camunda.bpm.engine.impl.incident.IncidentContext
import org.camunda.bpm.engine.runtime.Incident

class CustomIncidentHandler(
    type: String,
) : DefaultIncidentHandler(type) {

    override fun handleIncident(context: IncidentContext, message: String?): Incident {
        return super.handleIncident(context, message)
    }

}