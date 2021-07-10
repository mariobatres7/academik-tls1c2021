package edu.telus.parcial2.rest;

import edu.telus.parcial2.modelo.Factura;
import edu.telus.parcial2.modelo.FacturaDetalle;
import edu.telus.parcial2.servicio.FacturaDetalleServicio;
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
@Path("/facturasDetalle")
public class FacturaDetalleEndpoint {

    @Inject
    private FacturaDetalleServicio facturaDetalleServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacturaDetalle> findFacturaDetalleList() {
        return this.facturaDetalleServicio.findFacturaDetalleList();
    }
}
