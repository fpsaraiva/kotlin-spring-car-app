package dev.fpsaraiva.carapp.interfaces

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverAPITestIT {

    @LocalServerPort
    private var port: Int = 0

    @BeforeEach
    fun setup() {
        RestAssured.port = port
    }

    @Test
    fun createDriverTest() {
        val createDriverJSON = """
            {"name": "Fernando Saraiva",
             "birthDate": "1990-05-05"}
            """.trimIndent()

        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(createDriverJSON)
            .post("/drivers")
            .then()
            .statusCode(200)
            .body("id", Matchers.notNullValue())
            .body("name", Matchers.equalTo("Fernando Saraiva"))
            .body("birthDate", Matchers.equalTo("1990-05-05"))
    }
}