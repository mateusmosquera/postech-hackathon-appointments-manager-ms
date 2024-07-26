package br.com.fiap.appointments.infrastructure.web.messaging

import br.com.fiap.appointments.domain.entities.Appointments
import br.com.fiap.appointments.domain.entities.extension.toDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest

@Service
class SQSSenderService {
    private val sqsClient: SqsClient = SqsClient.create()

    @Value("\${integration.sqs.url.producer}")
    lateinit var sqsUrl: String

    fun send(appointment: Appointments) {

        val sendMsgRequest = SendMessageRequest.builder()
            .queueUrl(sqsUrl)
            .messageBody(appointment.toDTO().toString())
            .delaySeconds(5)
            .build()

        sqsClient.sendMessage(sendMsgRequest)
    }
}