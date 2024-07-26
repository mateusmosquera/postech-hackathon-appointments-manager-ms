package br.com.fiap.appointments.infrastructure.web.messaging

import br.com.fiap.appointments.domain.usecases.AppointmentsDomainUseCase
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class SQSListener(private val appointmentsDomainUseCase: AppointmentsDomainUseCase) {

    @JmsListener(destination = "\${integration.sqs.url.listener}")
    fun receive(message: String) {

        appointmentsDomainUseCase.updateAppointment(message)
    }
}