package br.com.fiap.appointments.domain.usecases

import br.com.fiap.appointments.application.gateway.AppointmentsRepositoryGateway
import br.com.fiap.appointments.domain.entities.Appointments
import br.com.fiap.appointments.domain.entities.enums.AppointmentStatus
import br.com.fiap.appointments.infrastructure.web.client.MedServiceClient
import br.com.fiap.appointments.infrastructure.web.client.PatientServiceClient
/* import br.com.fiap.appointments.infrastructure.web.messaging.SQSSenderService */
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AppointmentsDomainUseCase(@Qualifier("appointmentsJPARepository") private val appointmentsRepositoryGateway: AppointmentsRepositoryGateway,
                                private val medServiceClient: MedServiceClient,
                                private val patientServiceClient: PatientServiceClient,
//                                private val sqsSenderService: SQSSenderService
) {
    @Transactional
    fun create(appointments: Appointments): Appointments {

        medServiceClient.getMed(appointments.medId).also {
            if (!it.statusCode.is2xxSuccessful) {
                throw RuntimeException("MedId is not valid")
            }
        }

        patientServiceClient.getPatient(appointments.patientId).also {
            if (!it.statusCode.is2xxSuccessful) {
                throw RuntimeException("PatientId is not valid")
            }
        }

        val savedAppointment = appointmentsRepositoryGateway.save(appointments)
        //sqsSenderService.send(savedAppointment)


        return savedAppointment
    }

    fun updateAppointment(appointmentJsonStr: String){

        val mapper = jacksonObjectMapper()
        val typeReference = object : TypeReference<Map<String, Any>>() {}

        val appointmentMap = mapper.readValue(appointmentJsonStr, typeReference)

        appointmentsRepositoryGateway.findById((appointmentMap["id"] as Double).toLong())?.let {

            val updatedAppointment = it.apply {
                status = AppointmentStatus.valueOf(appointmentMap["status"]as String)
            }
            appointmentsRepositoryGateway.save(updatedAppointment)

        }
    }

}