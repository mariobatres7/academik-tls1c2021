package edu.telus.jpaweb.service;

import edu.telus.jpaweb.model.Usuario;
import edu.telus.jpaweb.model.UsuarioLog;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
@RequestScoped
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> findUsuarios() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);

        query.from(Usuario.class);

        return this.entityManager.createQuery(query).getResultList();
    }

    /*
    private void crearLog(Usuario usuario) {
        
        UsuarioLog usuarioLog = new UsuarioLog();
        usuarioLog.setRegistradoEl(LocalDateTime.now());
        usuarioLog.setUsuario(usuario);        
     
        this.entityManager.persist(usuarioLog);
        
    }*/

    @Transactional
    public void crearUsuario(Usuario usuario) { // abre una una nueva transaccion, begin()

        UsuarioLog usuarioLog = new UsuarioLog();
        usuarioLog.setRegistradoEl(LocalDateTime.now());
        usuarioLog.setUsuario(usuario);
        
        usuario.getUsuarioLogList().add(usuarioLog);
        
        this.entityManager.persist(usuario);
        
        //this.crearLog(usuario);

    } // en este momento se hace commit, commit()

}
