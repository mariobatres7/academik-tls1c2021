package edu.telus.primer.soap.webservice;

import edu.telus.primer.soap.model.Usuario;
import edu.telus.primer.soap.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
@WebService(
        name = "Usuario",
        targetNamespace = "http://edu.telus.soap/usuarios",
        serviceName = "UsuarioWebservice"
)
public class UsuarioWebservice {

    @Inject
    private UsuarioService usuarioService;

    @WebMethod
    public List<Usuario> findUsuarios() {
        var usuarioList = this.usuarioService.findUsuarios();
        return usuarioList;
    }
}
