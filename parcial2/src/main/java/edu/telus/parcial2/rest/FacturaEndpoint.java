package edu.telus.parcial2.rest;

import edu.telus.parcial2.modelo.Factura;
import edu.telus.parcial2.servicio.FacturaServicio;
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
@Path("/facturas")
public class FacturaEndpoint {

    @Inject
    private FacturaServicio facturaServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factura> findFacturaList() {
        return this.facturaServicio.findFacturaList();
    }
}
