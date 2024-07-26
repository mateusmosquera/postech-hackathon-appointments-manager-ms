package br.com.fiap.appointments.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "integration")
class IntegrationProperties (
    val med: Med?,
    val produto: Patient?
) {

    data class Med(
        val service: String,
    )

    data class Patient(
        val service: String
    )
}