package edu.telus.parcial2.servicio;

import edu.telus.parcial2.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class FacturaServicio {
    
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Factura> findFacturaList() {
        
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Factura> query = builder.createQuery(Factura.class);        
        query.from(Factura.class);

        return this.entityManager.createQuery(query).getResultList();
    }
}
