package edu.telus.primerjpa;

import edu.telus.primerjpa.modelo.Equipo;
import edu.telus.primerjpa.modelo.EquipoFinanciero;
import edu.telus.primerjpa.modelo.Equipo_;
import edu.telus.primerjpa.modelo.Pais;
import edu.telus.primerjpa.modelo.Perfil;
import edu.telus.primerjpa.modelo.PerfilRol;
import edu.telus.primerjpa.modelo.PerfilRolPK;
import edu.telus.primerjpa.modelo.PerfilRol_;
import edu.telus.primerjpa.modelo.Usuario;
import edu.telus.primerjpa.modelo.wrapper.EquipoWrapper1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void buscarEquiposPorExpresion(EntityManager entityManager, String expresion) {

        //select * from equipo e where e.nombre like ('%City%') 
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Equipo> query = builder.createQuery(Equipo.class);

        Root<Equipo> root = query.from(Equipo.class);

        query.where(
                builder.like(root.get(Equipo_.nombre), expresion)
        );

        entityManager.createQuery(query).getResultList().forEach(System.out::println);

    }

    public static void buscarEquipoPorId(EntityManager entityManager, Long id) {

        //select * from equipo e where e.id = 5
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Equipo> query = builder.createQuery(Equipo.class);

        Root<Equipo> root = query.from(Equipo.class);

        query.where(
                builder.equal(root.get(Equipo_.id), id)
        //builder.like(root.get(Equipo_.nombre), "%City%")
        );

        Equipo equipo = null;

        try {
            entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException nre) {
            System.err.println(nre.getMessage());
        } catch (NonUniqueResultException nure) {
            System.err.println("NonUniqueResult:  " + nure.getMessage());
        }

        System.out.println(equipo);
    }

    public void buscarCreadoElPorId(EntityManager entityManager, Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<LocalDateTime> query = builder.createQuery(LocalDateTime.class);

        Root<Equipo> root = query.from(Equipo.class);

        query.select(root.get(Equipo_.creadoEl));

        query.where(
                builder.equal(root.get(Equipo_.id), 5L)
        );

        LocalDateTime creadoEl = entityManager.createQuery(query).getSingleResult();

        System.out.println(creadoEl);
    }

    public static void buscarEquipoWrapper1ConTuple(EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Equipo> root = query.from(Equipo.class);

        query.multiselect(
                root.get(Equipo_.nombre).alias(Equipo_.NOMBRE),
                root.get(Equipo_.direccion).alias(Equipo_.DIRECCION),
                root.get(Equipo_.creadoEl).alias(Equipo_.CREADO_EL)
        );

        List<Tuple> resultList = entityManager.createQuery(query).getResultList();

        List<EquipoWrapper1> equipoWrapper1List = resultList.stream()
                .map(tuple -> {

                    var nombre = tuple.get(Equipo_.NOMBRE, String.class);
                    var direccion = tuple.get(Equipo_.DIRECCION, String.class);
                    var creadoEl = tuple.get(Equipo_.CREADO_EL, LocalDateTime.class);

                    EquipoWrapper1 equipoWrapper1 = new EquipoWrapper1();
                    equipoWrapper1.setNombre(nombre);
                    equipoWrapper1.setDireccion(direccion);
                    equipoWrapper1.setCreadoEl(creadoEl);

                    return equipoWrapper1;
                }).collect(Collectors.toList());

        equipoWrapper1List.forEach(System.out::println);
    }

    public static void buscarEquipoWrapper1(EntityManager entityManager) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<EquipoWrapper1> query = builder.createQuery(EquipoWrapper1.class);

        Root<Equipo> root = query.from(Equipo.class);

        query.multiselect(
                root.get(Equipo_.nombre),
                root.get(Equipo_.direccion),
                root.get(Equipo_.creadoEl)
        );

        List<EquipoWrapper1> resultList = entityManager.createQuery(query).getResultList();
        resultList.forEach(System.out::println);

    }

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("PrimerJPA_PU")
                .createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Long perfilId = 3L;
            Long[] rolesAAsignar = {1L, 2L};

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();

            CriteriaDelete<PerfilRol> queryDelete = builder.createCriteriaDelete(PerfilRol.class);

            Root<PerfilRol> root = queryDelete.from(PerfilRol.class);

            if (rolesAAsignar.length > 0) {
                queryDelete.where(
                        builder.equal(root.get(PerfilRol_.perfil), perfilId),
                        builder.not(root.get(PerfilRol_.rol).in((Object[]) rolesAAsignar))
                );
            } else {
                queryDelete.where(
                        builder.equal(root.get(PerfilRol_.perfil), perfilId)
                );
            }

            entityManager.createQuery(queryDelete).executeUpdate();

            Stream.of(rolesAAsignar).forEach(rolId -> {

                PerfilRolPK pk = new PerfilRolPK();
                pk.setPerfilId(perfilId);
                pk.setRolId(rolId);

                PerfilRol perfilRol = entityManager.find(PerfilRol.class, pk);

                if (perfilRol == null) {

                    perfilRol = new PerfilRol();
                    perfilRol.setPk(pk);
                    perfilRol.setAsignadoEl(LocalDateTime.now());

                    entityManager.persist(perfilRol);
                }
            });

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();

            System.err.println(ex.getMessage());
        }

        /*
        PerfilRolPK pk = new PerfilRolPK();
        pk.setPerfilId(3L);
        pk.setRolId(1L);
        
        PerfilRol perfilRol = entityManager.find(PerfilRol.class, pk);
        
        System.out.println(perfilRol.getAsignadoEl());*/
 /*  try {
            entityManager.getTransaction().begin();
            Perfil perfil = entityManager.find(Perfil.class, 3L);
            perfil.getPerfilRolSet().forEach(System.out::println);

            Long[] rolesAAsignar = {1L, 2L};

            Stream.of(rolesAAsignar).forEach(rolId -> {

                PerfilRolPK pk = new PerfilRolPK();
                pk.setPerfilId(perfil.getPerfilId());
                pk.setRolId(rolId);

                PerfilRol perfilRol = new PerfilRol();
                perfilRol.setPk(pk);
                perfilRol.setAsignadoEl(LocalDateTime.now());

                entityManager.persist(perfilRol);
            });

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();

            System.err.println(ex.getMessage());
        }*/
        entityManager.close();

        /*        try {
            entityManager.getTransaction().begin();

            Long[] perfilesAAsingar = {1L, 2L, 3L};

            Usuario usuario = entityManager.find(Usuario.class, 3L);

            usuario.getPerfilSet().clear();
            
            Stream.of(perfilesAAsingar)
                    .map(Perfil::new)
                    .forEach(usuario.getPerfilSet()::add);
            
            /*
            Stream.of(perfilesAAsingar)
                    .map(perfilId -> new Perfil(perfilId))                    
                    .forEach(perfil -> usuario.getPerfilSet().add(perfil));*/
 /*
            Stream.of(perfilesAAsingar).forEach(perfilId -> {
                Perfil perfil = new Perfil(perfilId);  //entityManager.find(Perfil.class, perfilId);
                usuario.getPerfilSet().add(perfil);
            });*/
 /*
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();

            System.err.println(ex.getMessage());
        }*/
    }
}
