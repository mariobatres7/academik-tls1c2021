package edu.telus.parcial2.servicio;

import edu.telus.parcial2.modelo.Factura;
import edu.telus.parcial2.modelo.FacturaDetalle;
import edu.telus.parcial2.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class FacturaDetalleServicio {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FacturaDetalle> findFacturaDetalleList() {
        
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        
        CriteriaQuery<FacturaDetalle> query = builder.createQuery(FacturaDetalle.class);        
        query.from(FacturaDetalle.class);

        return this.entityManager.createQuery(query).getResultList();
    }
}
