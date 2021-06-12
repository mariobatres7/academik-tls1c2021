package edu.telus.primer.rest.endpoint;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mario Batres
 */
@Path("/equipos")
public class EquipoEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("currentTime", System.currentTimeMillis());

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(item1);

        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("currentTime", System.currentTimeMillis());
        item1.put("id", id);
        return Response.ok(item1).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Map<String, Object> data) {
        data.put("method", "post");
        return Response.ok(data).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Map<String, Object> data) {
        data.put("method", "put");
        return Response.ok(data).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("currentTime", System.currentTimeMillis());
        item1.put("id", id);
        return Response.ok(item1).build();
    }
}
