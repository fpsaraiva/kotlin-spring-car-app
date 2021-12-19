package dev.fpsaraiva.carapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarAppApplication

fun main(args: Array<String>) {
	runApplication<CarAppApplication>(*args)
}
