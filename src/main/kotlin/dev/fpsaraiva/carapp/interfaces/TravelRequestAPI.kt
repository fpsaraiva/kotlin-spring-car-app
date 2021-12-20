package dev.fpsaraiva.carapp.interfaces

import dev.fpsaraiva.carapp.domain.TravelRequestInput
import dev.fpsaraiva.carapp.domain.TravelRequestOutput
import dev.fpsaraiva.carapp.domain.TravelService
import dev.fpsaraiva.carapp.interfaces.mapping.TravelRequestMapper
import org.springframework.hateoas.EntityModel
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
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput): EntityModel<TravelRequestOutput> {
        val travelRequest = travelService.saveTravelRequest(mapper.map(travelRequestInput))
        val output = mapper.mapOutput(travelRequest)
        return mapper.buildOutputModel(travelRequest, output)
    }
}