package com.github.alondero.formulapedia.drivers

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/drivers")
class DriverResource {

    @GET
    fun drivers() = "Hello World!"
}