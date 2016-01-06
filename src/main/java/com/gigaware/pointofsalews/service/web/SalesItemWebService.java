/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
@WebService ( name = "salesItemWebService")
public interface SalesItemWebService {
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path("/salesItems")
    public SalesItemWrapper getAllSalesItems();
    
}
