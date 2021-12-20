package dev.fpsaraiva.carapp.domain

import java.time.LocalDate

data class PatchDriver(
    val name: String?,
    val birthDate: LocalDate?
)

data class PatchPassenger(
    val name: String?
)

data class TravelRequestInput(
    val passengerId: Long,
    val origin: String,
    val destination: String
)