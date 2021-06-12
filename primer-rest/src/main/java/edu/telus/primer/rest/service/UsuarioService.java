package edu.telus.primer.rest.service;

import edu.telus.primer.rest.model.Usuario;
import edu.telus.primer.rest.model.UsuarioLog;
import edu.telus.primer.rest.model.UsuarioLog_;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
@RequestScoped
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UsuarioLog> findUsuarioLogs(Long usuarioId) {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<UsuarioLog> query = builder.createQuery(UsuarioLog.class);

        Root<UsuarioLog> root = query.from(UsuarioLog.class);

        query.where(builder.equal(root.get(UsuarioLog_.usuario), usuarioId));

        return this.entityManager.createQuery(query).getResultList();
    }

    public Usuario findUsuario(Long usuarioId) {
        return this.entityManager.find(Usuario.class, usuarioId);
    }

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

        usuario.setUsuarioId(null);

        UsuarioLog usuarioLog = new UsuarioLog();
        usuarioLog.setRegistradoEl(ZonedDateTime.now());
        usuarioLog.setUsuario(usuario);

        usuario.getUsuarioLogList().add(usuarioLog);

        this.entityManager.persist(usuario);

        //this.crearLog(usuario);
    } // en este momento se hace commit, commit()

    @Transactional
    public void actualizarUsuario(Usuario usuario) {
        this.entityManager.merge(usuario);
    }
}
