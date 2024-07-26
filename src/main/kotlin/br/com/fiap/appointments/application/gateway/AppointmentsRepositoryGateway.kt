package br.com.fiap.appointments.application.gateway

import br.com.fiap.appointments.domain.entities.Appointments
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AppointmentsRepositoryGateway {
    fun save(appointments: Appointments): Appointments
    fun findById(id: Long): Appointments?

}