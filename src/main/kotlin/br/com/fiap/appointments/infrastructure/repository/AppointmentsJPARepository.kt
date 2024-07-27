package br.com.fiap.appointments.infrastructure.repository

import br.com.fiap.appointments.application.gateway.AppointmentsRepositoryGateway
import br.com.fiap.appointments.domain.entities.Appointments
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppointmentsJPARepository : AppointmentsRepositoryGateway, JpaRepository<Appointments, Long>{

}