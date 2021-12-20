package dev.fpsaraiva.carapp.domain

import java.time.LocalDate

data class PatchDriver(
    val name: String?,
    val birthDate: LocalDate?
)

data class PatchPassenger(
    val name: String?
)