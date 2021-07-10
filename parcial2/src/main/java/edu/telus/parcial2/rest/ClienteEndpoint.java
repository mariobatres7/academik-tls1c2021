package edu.telus.parcial2.rest;

import edu.telus.parcial2.modelo.Cliente;
import edu.telus.parcial2.servicio.ClienteServicio;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
@Path("/clientes")
public class ClienteEndpoint {

    @Inject
    private ClienteServicio clienteServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> clienteList() {
        return this.clienteServicio.findClienteList();
    }
}
