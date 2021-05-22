package edu.telus.jakartaee9.test101.rest;

import edu.telus.jakartaee9.test101.service.HelloService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;

/**
 *
 * @author Mario Batres
 */
@Path("/hello")
public class HelloEndpoint {

    @Inject
    private HelloService helloService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello() {

        Map result = Map.of("message", this.helloService.sayHello());

        return Response.ok(result).build();
    }

}
