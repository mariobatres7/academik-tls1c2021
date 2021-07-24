package edu.telus.demo.proyecto.repositorio;

import edu.telus.demo.proyecto.dominio.Persona;
import edu.telus.demo.proyecto.dominio.Persona_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author Mario Batres
 */
public class PersonaRepositorio {

    //El final solo es cuando no usamos CDI
    //nos dice que tenemos que asignarle el valor dentro del constructor
    private final EntityManager entityManager;

    //Lo usamos cuando no tenemos CDI, o sea, no usamos WildFly u otro servidor de aplicación.
    public PersonaRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Persona buscarPersonaPorCodigo(String codigo) {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);

        Root<Persona> root = personaQuery.from(Persona.class);

        personaQuery.where(
                builder.equal(root.get(Persona_.codigo), codigo)
        );

        try {
            return this.entityManager.createQuery(personaQuery).getSingleResult();
        } catch (NoResultException ex) {

        }
        return null;

    }

    public void crearOActualizarPersona(Persona personaNuevo) {

        Persona persona = this.buscarPersonaPorCodigo(personaNuevo.getCodigo());

        if (persona == null) {            
            //para crear el registro de persona
            this.entityManager.persist(personaNuevo);
        } else {
            persona.setNombre(personaNuevo.getNombre());
            persona.setAnyoNacimiento(personaNuevo.getAnyoNacimiento());
            persona.setAnyoFallecimiento(personaNuevo.getAnyoFallecimiento());            
            persona.setProfesionSet(personaNuevo.getProfesionSet());            

            this.entityManager.merge(persona);

        }

    }
}
