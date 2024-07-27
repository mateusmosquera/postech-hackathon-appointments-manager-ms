package br.com.fiap.appointments.application.controller

import br.com.fiap.appointments.application.dto.request.AppointmentsRequest
import br.com.fiap.appointments.application.dto.response.AppointmentsResponse
import br.com.fiap.appointments.domain.entities.extension.toDTO
import br.com.fiap.appointments.domain.entities.extension.toEntity
import br.com.fiap.appointments.domain.usecases.AppointmentsDomainUseCase
import org.springframework.stereotype.Service

@Service
class AppointmentsApplicationController(private val appointmentsDomainUseCase: AppointmentsDomainUseCase) {

    fun create(appointments: AppointmentsRequest): AppointmentsResponse =
        appointmentsDomainUseCase.create(appointments.toEntity()).toDTO()

}