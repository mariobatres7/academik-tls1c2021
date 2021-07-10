package edu.telus.parcial2.servicio;

import edu.telus.parcial2.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class ClienteServicio {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cliente> findClienteList() {
        return this.entityManager.createQuery("select c from Cliente as c", Cliente.class).getResultList();
    }
}
