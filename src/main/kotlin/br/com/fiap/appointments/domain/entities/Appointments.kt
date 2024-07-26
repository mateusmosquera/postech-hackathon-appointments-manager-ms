package br.com.fiap.appointments.domain.entities

import br.com.fiap.appointments.domain.entities.enums.AppointmentStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Appointments(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointments_id_seq")
    @SequenceGenerator(name = "appointments_id_seq", sequenceName = "appointments_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "med_id", nullable = false)
    var medId: Long,

    @Column(name = "patient_id", nullable = false)
    val patientId: Long,

    @Column(name = "start_time", nullable = false)
    var startTime: LocalDateTime,

    @Column(name = "end_time", nullable = false)
    var endTime: LocalDateTime,

    @Column(name = "cost", precision = 19, scale = 2)
    val cost: BigDecimal? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: AppointmentStatus = AppointmentStatus.REQUESTED,

    @Column(name = "cancel_reason")
    var cancelReason: String? = null,

    @Column(name = "appointment_link")
    var appointmentLink: String? = null,

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    var createDate: LocalDateTime? = null,
    @LastModifiedDate
    @Column(name = "update_date", nullable = false, updatable = false)
    var updateDate: LocalDateTime? = null)
