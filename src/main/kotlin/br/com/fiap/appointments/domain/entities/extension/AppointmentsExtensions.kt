package br.com.fiap.appointments.domain.entities.extension

import br.com.fiap.appointments.application.dto.request.AppointmentsRequest
import br.com.fiap.appointments.application.dto.response.AppointmentsResponse
import br.com.fiap.appointments.domain.entities.Appointments

fun Appointments.toDTO() = AppointmentsResponse(id = id, medId = medId, patientId = patientId, startTime = startTime, endTime = endTime)
fun AppointmentsRequest.toEntity() = Appointments (id = null, medId = medId, patientId = patientId, startTime = startTime, endTime = endTime)
