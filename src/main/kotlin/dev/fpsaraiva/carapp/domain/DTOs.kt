package dev.fpsaraiva.carapp.domain

import dev.fpsaraiva.carapp.domain.enums.TravelRequestStatus
import java.time.LocalDate
import java.time.LocalDateTime

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

data class TravelRequestOutput(
    val	id:	Long,
    val	origin:	String,
    val	destination: String,
    val	status: TravelRequestStatus,
    val	creationDate: LocalDateTime
)
