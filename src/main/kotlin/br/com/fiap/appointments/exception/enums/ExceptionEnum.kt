package br.com.fiap.appointments.exception.enums

import br.com.fiap.appointments.exception.dto.ResponseErrorDto

fun interface ExceptionEnum {
    fun getResponseError(): ResponseErrorDto
}