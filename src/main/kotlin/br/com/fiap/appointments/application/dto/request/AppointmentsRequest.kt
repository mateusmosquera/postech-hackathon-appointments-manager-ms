package br.com.fiap.appointments.application.dto.request

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class AppointmentsRequest(@field:NotBlank val id: Long,
                      @field:NotBlank val medId: Long,
                      @field:NotBlank val patientId: Long,
                      @field:NotBlank val startTime: LocalDateTime,
                      @field:NotBlank val endTime: LocalDateTime
                      )