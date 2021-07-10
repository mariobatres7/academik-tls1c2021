package edu.telus.parcial2.servicio;

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
public class ProductoServicio {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> findProductoList() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        // select * 
        CriteriaQuery<Producto> query = builder.createQuery(Producto.class);

        // from producto
        query.from(Producto.class);

        return this.entityManager.createQuery(query).getResultList();
    }

}
