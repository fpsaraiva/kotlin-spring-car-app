package dev.fpsaraiva.carapp.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Driver(

    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String,
    val birthDate: LocalDate
)

@Entity
data class Passenger(

    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String
)