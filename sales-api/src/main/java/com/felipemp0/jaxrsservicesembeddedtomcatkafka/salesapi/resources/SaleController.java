package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.resources;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.services.SaleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

@Path("sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController() {
        this.saleService = new SaleService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() throws ExecutionException, InterruptedException {
        this.saleService.sendSaleEvent("test1", "value1");

        return Response.status(Response.Status.OK).entity("Sale controller").build();
    }

}
