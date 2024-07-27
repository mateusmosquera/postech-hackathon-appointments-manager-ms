package br.com.fiap.appointments.exception

import br.com.fiap.appointments.exception.enums.ExceptionEnum

class BusinessException(val exceptionEnum: ExceptionEnum,
                        val messages: List<String> = emptyList()) : Exception()