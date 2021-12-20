package dev.fpsaraiva.carapp.domain

import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository: JpaRepository<Driver, Long>

interface PassengerRepository: JpaRepository<Passenger, Long>