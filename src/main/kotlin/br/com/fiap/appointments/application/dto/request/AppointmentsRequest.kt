package br.com.fiap.appointments.application.dto.request

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class AppointmentsRequest(
                      @field:NotNull val medId: Long,
                      @field:NotNull val patientId: Long,
                      @field:NotNull val startTime: LocalDateTime,
                      @field:NotNull val endTime: LocalDateTime
                      )