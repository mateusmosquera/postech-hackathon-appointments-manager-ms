package br.com.fiap.appointments.infrastructure.web.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "medService", url = "\${integration.med.service}")
interface MedServiceClient {
    @GetMapping("/med/{id}")
    fun getMed(@PathVariable("id") id: Long): ResponseEntity<Any>
}
