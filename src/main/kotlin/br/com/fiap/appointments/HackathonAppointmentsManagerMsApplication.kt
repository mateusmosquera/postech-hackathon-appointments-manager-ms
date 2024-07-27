package br.com.fiap.appointments

import br.com.fiap.appointments.config.IntegrationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(IntegrationProperties::class)
class HackathonAppointmentsManagerMsApplication

fun main(args: Array<String>) {
	runApplication<HackathonAppointmentsManagerMsApplication>(*args)
}
