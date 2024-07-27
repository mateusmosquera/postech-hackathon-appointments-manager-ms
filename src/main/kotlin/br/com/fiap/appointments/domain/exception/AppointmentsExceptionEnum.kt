package br.com.fiap.appointments.domain.exception

import br.com.fiap.appointments.exception.dto.ResponseErrorDto
import br.com.fiap.appointments.exception.enums.ExceptionEnum
import org.springframework.http.HttpStatus

enum class AppointmentsExceptionEnum(private val error: String,
                            private val httpStatusCode: HttpStatus) : ExceptionEnum {

    MED_NOT_FOUND("Appointments not found.", HttpStatus.NOT_FOUND);

    override fun getResponseError(): ResponseErrorDto {
        return ResponseErrorDto(error = error, status = httpStatusCode.value())
    }

}