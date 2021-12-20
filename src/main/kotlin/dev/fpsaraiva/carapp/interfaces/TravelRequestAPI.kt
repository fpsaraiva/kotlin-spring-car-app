package dev.fpsaraiva.carapp.interfaces

import dev.fpsaraiva.carapp.domain.TravelRequestInput
import dev.fpsaraiva.carapp.domain.TravelService
import dev.fpsaraiva.carapp.interfaces.mapping.TravelRequestMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(path = ["/travelrequests"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI(
    val travelService: TravelService,
    val mapper: TravelRequestMapper
) {

    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput) {
        travelService.saveTravelRequest(mapper.map(travelRequestInput))
    }
}