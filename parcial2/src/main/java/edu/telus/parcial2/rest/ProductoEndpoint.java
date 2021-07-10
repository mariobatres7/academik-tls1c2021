package edu.telus.parcial2.rest;

import edu.telus.parcial2.modelo.Producto;
import edu.telus.parcial2.servicio.ProductoServicio;
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
@Path("/productos")
public class ProductoEndpoint {

    @Inject //CDI
    private ProductoServicio productoServicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findProductoList() {
        return this.productoServicio.findProductoList();
    }
}
