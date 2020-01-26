package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sales")
public class SaleController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        return Response.status(Response.Status.OK).entity("Sale controller").build();
    }

}
