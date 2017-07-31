package com.aks.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Uses jboss.resteasy
 * 
 * @author anurag.kumar
 *
 */
@Path("/publish")
public class RestExampleJbossRestEasy1 {
 
    @GET
    @Path("/response/{message}")
    public Response publishMessage(@PathParam("message") String msgStr){
         
        String responseStr = "Response for received message: "+msgStr;
        return Response.status(200).entity(responseStr).build();
    }
    
    @GET
    @Path("/query/{message}")
    public Response publishInfo(@PathParam("message") String msgStr){
         
        String responseStr = "Response for received request: "+msgStr;
        return Response.status(200).entity(responseStr).build();
    }
    
}
