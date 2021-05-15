package edu.telus.primerjpa;

import edu.telus.primerjpa.modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public static void buscarEquiposPorJPQL(EntityManager entityManager) {

        List<Equipo> equipoList = entityManager
                .createQuery("select e from Equipo as e", Equipo.class)
                .getResultList();

        equipoList.stream().forEach(System.out::println);

        /*
           String queryString = "select * from equipo";

        List<Equipo> equipoList = new ArrayList<>();

        try (PreparedStatement stmt = ConexionDBSingleton.getConnection().prepareStatement(queryString)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setId(rs.getInt("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setDireccion(rs.getString("direccion"));

                    equipoList.add(equipo);
                }
            }
        }


         */
    }

    // SQL:   select * from equipo
    public static void buscarEquiposPorCriteria(EntityManager entityManager) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        System.out.println("Query con JPA Criterias");
        // select * 
        CriteriaQuery<Equipo> query = builder.createQuery(Equipo.class);
        query.from(Equipo.class);

        List<Equipo> equipoList = entityManager.createQuery(query).getResultList();

        equipoList.stream().forEach(System.out::println);
    }

    public static void buscaEquiposPorId(EntityManager entityManager, Integer id) {
        // SQL:   select * from equipo where id = 5
        Equipo equipo = entityManager.find(Equipo.class, id);

        System.out.println(equipo);
    }

    public static void crearEquipo(EntityManager entityManager) {
        try {
            entityManager.getTransaction().begin();

            Equipo equipo = new Equipo();
            equipo.setNombre("Newcastle United");
            equipo.setDireccion("Newcastle, Inglaterra");
            entityManager.persist(equipo);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.err.println(ex.getMessage());
        }
    }
    
     public static void updateEquipo(EntityManager entityManager) {
        try {
            entityManager.getTransaction().begin();

            Equipo equipo = entityManager.find(Equipo.class, 6);
            equipo.setDireccion("Newcastle, Inglaterra, UK");    
            
            entityManager.merge(equipo);        
            
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.err.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("PrimerJPA_PU")
                .createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Equipo equipo = entityManager.find(Equipo.class, 6);
            entityManager.remove(equipo);
            
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.err.println(ex.getMessage());
        }

        entityManager.close();

    }
}
