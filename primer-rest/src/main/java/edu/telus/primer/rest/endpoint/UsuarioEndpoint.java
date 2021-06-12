package edu.telus.primer.rest.endpoint;

import edu.telus.primer.rest.model.Usuario;
import edu.telus.primer.rest.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Mario Batres
 */
@Path("/usuarios")
public class UsuarioEndpoint {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarios() {
        var usuarioList = this.usuarioService.findUsuarios();
        return Response.ok(usuarioList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarios(@PathParam("id") Long id) {
        var usuario = this.usuarioService.findUsuario(id);
        return Response.ok(usuario).build();
    }

    @GET
    @Path("/logs/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarioLogs(@PathParam("id") Long id) {
        var list = this.usuarioService.findUsuarioLogs(id);
        return Response.ok(list).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(@Valid Usuario usuario) {
        this.usuarioService.crearUsuario(usuario);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(@Valid Usuario usuario) {
        this.usuarioService.actualizarUsuario(usuario);
        return Response.ok().build();

    }
}
