package br.com.fiap.appointments.infrastructure.web.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "patientService", url = "\${integration.patient.service}")
interface PatientServiceClient {
    @GetMapping("/patient/{id}")
    fun getPatient(@PathVariable("id") id: Long): ResponseEntity<Any>
}