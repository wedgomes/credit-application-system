package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Ivalide input") val firstName: String,
    @field:NotEmpty(message = "Ivalide input") val lastName: String,
    @field:NotEmpty(message = "Ivalide input")
    @CPF(message = "This invalid CPF") val cpf: String,
    @NotNull(message = "Invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "Ivalide Email")
    @field:NotEmpty(message = "Ivalide input") val email: String,
    @field:NotEmpty(message = "Ivalide input") val password: String,
    @field:NotEmpty(message = "Ivalide input") val zipCode: String,
    @field:NotEmpty(message = "Ivalide input") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address()
    )
}
