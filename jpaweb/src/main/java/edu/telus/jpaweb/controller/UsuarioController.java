package edu.telus.jpaweb.controller;

import edu.telus.jpaweb.model.Usuario;
import edu.telus.jpaweb.service.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import lombok.Getter;
import lombok.extern.java.Log;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
@Log
public class UsuarioController implements Serializable {

    @Inject
    private UsuarioService usuarioService;

    @Getter
    private List<Usuario> usuarioList;

    @Getter
    private Usuario usuario;

    @PostConstruct
    public void init() {

        this.usuarioList = this.usuarioService.findUsuarios();

        this.usuario = new Usuario();

    }

    public void crearUsuario() {
        try {

            this.usuarioService.crearUsuario(this.usuario);

            this.init();

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usuario creado satisfactoriamente.");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception ex) {

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                        
            log.log(Level.SEVERE, "Error", ex);

        }
    }

}
