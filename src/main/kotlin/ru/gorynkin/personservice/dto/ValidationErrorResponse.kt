package ru.gorynkin.personservice.dto

data class ValidationErrorResponse(
    override val message: String?,
    val errors: Map<String, ru.gorynkin.personservice.dto.ValidationErrorResponse.FieldMessage> = emptyMap()
): ru.gorynkin.personservice.dto.ErrorResponse(message) {
    data class FieldMessage(
        val rejectedValue: Any?,
        val defaultMessage: String?
    )
}
