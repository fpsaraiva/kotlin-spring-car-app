package dev.fpsaraiva.carapp.interfaces

import dev.fpsaraiva.carapp.domain.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.annotation.security.RolesAllowed

@Service
@RestController
@RequestMapping(path = ["/passengers"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PassengerAPI(
    val passengerRepository: PassengerRepository
) {

    @GetMapping
    fun listPassengers() = passengerRepository.findAll()

    @GetMapping("/{id}")
    fun listPassenger(@PathVariable("id") id: Long) = passengerRepository.findById(id)
        .orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    fun createPassenger(@RequestBody passenger: Passenger) = passengerRepository.save(passenger)

    @PutMapping("/{id}")
    fun fullUpdatePassenger(@PathVariable("id") id:Long, @RequestBody passenger: Passenger) : Passenger {
        val newPassenger = passengerRepository.findById(id).get().copy(
            name = passenger.name
        )
        return passengerRepository.save(newPassenger)
    }

    @PatchMapping("/{id}")
    fun incrementalUpdatePassenger(@PathVariable("id") id: Long, @RequestBody passenger: PatchPassenger): Passenger {
        val foundPassenger = passengerRepository.findById(id).get()
        val newPassenger = foundPassenger.copy(
            name = passenger.name ?: foundPassenger.name
        )
        return passengerRepository.save(newPassenger)
    }

    //não está sendo tratado erro quando passageiro já foi deletado
    @DeleteMapping("/{id}")
    fun deletePassenger(@PathVariable("id") id: Long) = passengerRepository.deleteById(id)
}