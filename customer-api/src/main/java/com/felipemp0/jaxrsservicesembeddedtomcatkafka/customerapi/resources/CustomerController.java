package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customers")
public class CustomerController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        return Response.status(Response.Status.OK).entity("Customer controller").build();
    }

}
