package org.sample.home.controller

import org.sample.home.service.ProcessService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val processService: ProcessService
) {

    @PostMapping("/start")
    fun startProcess() {
        processService.startProcess()
    }

}