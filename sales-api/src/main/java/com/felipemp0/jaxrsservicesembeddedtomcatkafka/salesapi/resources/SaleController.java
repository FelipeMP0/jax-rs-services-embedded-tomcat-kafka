package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.resources;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.models.Sale;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.services.SaleService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController() {
        this.saleService = new SaleService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet(Sale sale) {
        this.saleService.sendSaleEvent(sale);

        return Response.status(Response.Status.OK).entity(sale).build();
    }

}
