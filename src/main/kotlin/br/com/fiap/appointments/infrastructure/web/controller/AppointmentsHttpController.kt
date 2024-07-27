package br.com.fiap.appointments.infrastructure.web.controller

import br.com.fiap.appointments.application.controller.AppointmentsApplicationController
import br.com.fiap.appointments.application.dto.request.AppointmentsRequest
import br.com.fiap.appointments.application.dto.response.AppointmentsResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/appointments")
class AppointmentsHttpController(private val appointmentsService: AppointmentsApplicationController) {

    @PostMapping
    fun create(@Valid @RequestBody appointments: AppointmentsRequest,
               uriBuilder: UriComponentsBuilder): ResponseEntity<AppointmentsResponse> {
        val appointmentsCreated = appointmentsService.create(appointments)
        val uri = uriBuilder.path("/api/v1/appointments/{id}").buildAndExpand(appointmentsCreated.id).toUri()
        return ResponseEntity.created(uri).body(appointmentsCreated)
    }

}

