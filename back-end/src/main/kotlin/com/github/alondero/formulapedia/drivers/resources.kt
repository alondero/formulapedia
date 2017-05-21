package com.github.alondero.formulapedia.drivers

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/drivers")
class DriverResource {

    @GET
    fun drivers() = listOf(
            Driver("Lewis Hamilton", "British"),
            Driver("Valtteri Bottas", "Finnish")
    )
}

data class Driver (val name: String, val nationality: String)