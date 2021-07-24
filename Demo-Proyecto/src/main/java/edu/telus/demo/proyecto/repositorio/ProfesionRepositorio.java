package edu.telus.demo.proyecto.repositorio;

import edu.telus.demo.proyecto.dominio.Profesion;
import edu.telus.demo.proyecto.dominio.Profesion_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class ProfesionRepositorio {

    private final EntityManager entityManager;

    public ProfesionRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Profesion> buscarProfesiones() {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);
        
        profesionQuery.from(Profesion.class);
        
        return this.entityManager.createQuery(profesionQuery).getResultList();
    }

    public Profesion buscarProfesionPorNombre(String nombre) {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);

        Root<Profesion> root = profesionQuery.from(Profesion.class);

        profesionQuery.where(
                builder.equal(root.get(Profesion_.nombre), nombre)
        );

        try {
            return this.entityManager.createQuery(profesionQuery).getSingleResult();
        } catch (NoResultException ex) {

        }
        return null;

    }

    public void crearOrActualizarProfesion(Profesion profesionNuevo) {

        Profesion profesion = this.buscarProfesionPorNombre(profesionNuevo.getNombre());

        if (profesion == null) {            
            this.entityManager.persist(profesionNuevo);
        } else {
            profesion.setDescripcion(profesionNuevo.getDescripcion());            
            this.entityManager.merge(profesion);
        }
    }

}
