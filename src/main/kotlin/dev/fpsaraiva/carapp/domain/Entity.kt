package dev.fpsaraiva.carapp.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

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

@Entity
data class TravelRequest(

    @Id
    @GeneratedValue
    var	id:	Long? = null,

    @ManyToOne
    val	passenger: Passenger,
    val	origin:	String,
    val	destination: String
)
